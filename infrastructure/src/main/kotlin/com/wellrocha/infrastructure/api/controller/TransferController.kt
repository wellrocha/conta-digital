package com.wellrocha.infrastructure.api.controller

import com.wellrocha.core.account.application.port.incoming.TransferAmountUseCasePort
import com.wellrocha.infrastructure.api.dto.TransferAmountRequest
import jakarta.persistence.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("transfers")
class TransferController(private val transferAmountUseCasePort: TransferAmountUseCasePort) {
    @PostMapping
    fun transfer(@RequestBody @Valid transferAmountRequest: TransferAmountRequest) {
        transferAmountUseCasePort.execute(
            transferAmountRequest.fromEmail,
            transferAmountRequest.toEmail,
            transferAmountRequest.amount
        )
    }
}
