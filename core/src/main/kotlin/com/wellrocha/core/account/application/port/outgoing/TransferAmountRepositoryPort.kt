package com.wellrocha.core.account.application.port.outgoing

import java.math.BigDecimal

interface TransferAmountRepositoryPort {
    fun transfer(fromEmail: String, toEmail: String, amount: BigDecimal)
}