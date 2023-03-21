package com.wellrocha.infrastructure.api.dto

import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal

data class TransferAmountRequest(
    @get:NotEmpty val fromEmail: String,
    @get:NotEmpty val toEmail: String,
    val amount: BigDecimal
)
