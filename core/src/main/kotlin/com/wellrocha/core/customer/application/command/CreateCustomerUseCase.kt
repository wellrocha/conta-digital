package com.wellrocha.core.customer.application.command

import com.wellrocha.core.customer.application.port.incoming.CreateCustomerUseCasePort
import com.wellrocha.core.customer.application.port.outgoing.CustomerRepositoryPort
import com.wellrocha.core.customer.domain.entity.CustomerEntity
import com.wellrocha.core.customer.domain.error.AlreadyExistsException

class CreateCustomerUseCase(private val customerRepositoryPort: CustomerRepositoryPort) : CreateCustomerUseCasePort {
    override fun execute(fullName: String, cpf: String): CustomerEntity {
        customerRepositoryPort.findByCpf(cpf)?.let {
            throw AlreadyExistsException("Customer ${it.fullName} Already Exists")
        }

        return customerRepositoryPort.create(fullName, cpf)
    }
}