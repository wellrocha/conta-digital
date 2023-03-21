package com.wellrocha.core.account.application.port.incoming

import java.math.BigDecimal

interface TransferAmountUseCasePort {
    fun execute(fromEmail: String, toEmail: String, amount: BigDecimal)
}