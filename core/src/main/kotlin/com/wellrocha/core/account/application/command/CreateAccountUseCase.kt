package com.wellrocha.core.account.application.command

import com.wellrocha.core.account.application.port.incoming.CreateAccountUseCasePort
import com.wellrocha.core.account.application.port.outgoing.AccountRepositoryPort
import com.wellrocha.core.account.application.dto.AccountDto
import com.wellrocha.core.error.AlreadyExistsException

class CreateAccountUseCase(private val accountRepositoryPort: AccountRepositoryPort) : CreateAccountUseCasePort {
    override fun execute(email: String) : AccountDto {
        accountRepositoryPort.findByEmail(email)?.let {
            throw AlreadyExistsException("Account ${it.email} Already Exists")
        }

        return accountRepositoryPort.create(email)
    }
}