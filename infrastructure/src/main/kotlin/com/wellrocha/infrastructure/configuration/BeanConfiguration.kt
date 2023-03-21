package com.wellrocha.infrastructure.configuration

import com.wellrocha.core.account.application.command.CreateAccountUseCase
import com.wellrocha.core.account.application.command.TransferAmountUseCase
import com.wellrocha.core.account.application.port.incoming.CreateAccountUseCasePort
import com.wellrocha.core.account.application.port.incoming.TransferAmountUseCasePort
import com.wellrocha.core.account.application.port.outgoing.AccountRepositoryPort
import com.wellrocha.core.account.application.port.outgoing.TransferAmountRepositoryPort
import com.wellrocha.core.customer.application.command.CreateCustomerUseCase
import com.wellrocha.core.customer.application.port.incoming.CreateCustomerUseCasePort
import com.wellrocha.core.customer.application.port.outgoing.CustomerRepositoryPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {
    @Bean
    fun createCustomerUseCase(customerRepositoryPort: CustomerRepositoryPort) : CreateCustomerUseCasePort {
        return CreateCustomerUseCase(customerRepositoryPort)
    }

    @Bean
    fun createAccountUseCase(accountRepositoryPort: AccountRepositoryPort) : CreateAccountUseCasePort {
        return CreateAccountUseCase(accountRepositoryPort)
    }

    @Bean
    fun transferAmountUseCase(transferAmountRepositoryPort: TransferAmountRepositoryPort): TransferAmountUseCasePort {
        return TransferAmountUseCase(transferAmountRepositoryPort)
    }
}