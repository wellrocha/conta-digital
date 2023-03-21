package com.wellrocha.infrastructure.database.adapter

import com.wellrocha.core.account.application.port.outgoing.TransferAmountRepositoryPort
import com.wellrocha.infrastructure.database.error.InsufficientBalanceException
import com.wellrocha.infrastructure.database.error.AccountNotFoundException
import com.wellrocha.infrastructure.database.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.Instant

@Service
class TransferAmountAdapter(private val accountRepository: AccountRepository) : TransferAmountRepositoryPort {
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    override fun transfer(fromEmail: String, toEmail: String, amount: BigDecimal) {
        val fromAccount = accountRepository.findByEmail(fromEmail) ?: throw AccountNotFoundException("From Email Not Found")
        val toAccount = accountRepository.findByEmail(toEmail) ?: throw AccountNotFoundException("To Email Not Found")

        if (fromAccount.balance < amount) {
            throw InsufficientBalanceException("User ${fromAccount.email} doesn't have enough balance")
        }

        fromAccount.balance = fromAccount.balance.plus(amount.multiply(BigDecimal(-1)))
        fromAccount.updatedAt = Instant.now()

        toAccount.balance = toAccount.balance.plus(amount)
        toAccount.updatedAt = Instant.now()
    }
}