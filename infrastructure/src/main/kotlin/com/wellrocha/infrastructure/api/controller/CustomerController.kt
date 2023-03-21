package com.wellrocha.infrastructure.api.controller

import com.wellrocha.core.customer.application.port.incoming.CreateCustomerUseCasePort
import com.wellrocha.core.customer.application.dto.CustomerDto
import com.wellrocha.infrastructure.api.dto.CreateCustomerRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("customers")
class CustomerController(private val createCustomerUseCasePort: CreateCustomerUseCasePort) {

    @PostMapping
    fun create(
        @RequestBody @Valid createCustomerRequest: CreateCustomerRequest,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<CustomerDto> {
        createCustomerUseCasePort.execute(createCustomerRequest.fullName, createCustomerRequest.cpf).let {
            return ResponseEntity
                .created(uriBuilder.path("/customers/{id}").buildAndExpand(it.id).toUri())
                .body(it)
        }
    }
}