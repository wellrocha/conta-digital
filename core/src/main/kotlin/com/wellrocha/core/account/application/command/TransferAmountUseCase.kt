package com.wellrocha.core.account.application.command

import com.wellrocha.core.account.application.port.incoming.TransferAmountUseCasePort
import com.wellrocha.core.account.application.port.outgoing.TransferAmountRepositoryPort
import java.math.BigDecimal

class TransferAmountUseCase(
    private val transferAmountRepositoryPort: TransferAmountRepositoryPort
) : TransferAmountUseCasePort {
    override fun execute(fromEmail: String, toEmail: String, amount: BigDecimal) {
        transferAmountRepositoryPort.transfer(fromEmail, toEmail, amount)
    }
}