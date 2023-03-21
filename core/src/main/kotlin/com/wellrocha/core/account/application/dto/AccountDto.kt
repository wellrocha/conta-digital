package com.wellrocha.core.account.application.dto

import java.math.BigDecimal
import java.time.Instant
import java.util.*

data class AccountDto(
    val id: UUID,
    val email: String,
    var balance: BigDecimal,
    val createdAt: Instant,
    val updatedAt: Instant,
)