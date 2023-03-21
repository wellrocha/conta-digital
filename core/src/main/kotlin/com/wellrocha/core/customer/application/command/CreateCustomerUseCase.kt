package com.wellrocha.core.customer.application.command

import com.wellrocha.core.customer.application.port.incoming.CreateCustomerUseCasePort
import com.wellrocha.core.customer.application.port.outgoing.CustomerRepositoryPort
import com.wellrocha.core.customer.application.dto.CustomerDto
import com.wellrocha.core.error.AlreadyExistsException

class CreateCustomerUseCase(private val customerRepositoryPort: CustomerRepositoryPort) : CreateCustomerUseCasePort {
    override fun execute(fullName: String, cpf: String): CustomerDto {
        customerRepositoryPort.findByCpf(cpf)?.let {
            throw AlreadyExistsException("Customer ${it.fullName} CPF ${it.cpf} Already Exists")
        }

        return customerRepositoryPort.create(fullName, cpf)
    }
}