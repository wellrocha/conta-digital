package com.wellrocha.infrastructure.database.adapter

import com.wellrocha.core.account.application.dto.AccountDto
import com.wellrocha.core.account.application.port.outgoing.AccountRepositoryPort
import com.wellrocha.infrastructure.database.entity.Account
import com.wellrocha.infrastructure.database.repository.AccountRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class AccountRepositoryAdapter(private val accountRepository: AccountRepository) : AccountRepositoryPort {
    override fun create(email: String): AccountDto {
        val account = Account(id = UUID.randomUUID(), email = email, balance = BigDecimal.ZERO)
        accountRepository.save(account).let {
            return AccountDto(
                id = it.id,
                email = it.email,
                balance = it.balance,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
    }

    override fun findByEmail(email: String): AccountDto? {
        accountRepository.findByEmail(email)?.let {
            return AccountDto(
                id = it.id,
                email = it.email,
                balance = it.balance,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }

        return null
    }
}