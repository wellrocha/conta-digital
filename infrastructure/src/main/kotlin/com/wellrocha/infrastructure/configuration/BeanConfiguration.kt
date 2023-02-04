package com.wellrocha.infrastructure.configuration

import com.wellrocha.core.customer.application.command.CreateCustomerUseCase
import com.wellrocha.core.customer.application.port.incoming.CreateCustomerUseCasePort
import com.wellrocha.core.customer.application.port.outgoing.CustomerRepositoryPort
import com.wellrocha.infrastructure.database.adapter.CustomerRepositoryAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {
    @Bean
    fun createCustomerUseCase(customerRepositoryPort: CustomerRepositoryPort) : CreateCustomerUseCasePort {
        return CreateCustomerUseCase(customerRepositoryPort)
    }
}