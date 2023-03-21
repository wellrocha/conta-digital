package com.wellrocha.infrastructure.api.controller

import com.wellrocha.core.account.application.port.incoming.CreateAccountUseCasePort
import com.wellrocha.core.account.application.dto.AccountDto
import com.wellrocha.infrastructure.api.dto.CreateAccountRequest
import jakarta.persistence.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("accounts")
class AccountController(private val createAccountUseCasePort: CreateAccountUseCasePort) {
    @PostMapping
    fun create(
        @RequestBody @Valid createAccountRequest: CreateAccountRequest,
        uriBuilder: UriComponentsBuilder,
    ) : ResponseEntity<AccountDto> {
        createAccountUseCasePort.execute(createAccountRequest.email).let {
            return ResponseEntity
                .created(uriBuilder.path("/accounts/{id}").buildAndExpand(it.id).toUri())
                .body(it)
        }
    }
}
