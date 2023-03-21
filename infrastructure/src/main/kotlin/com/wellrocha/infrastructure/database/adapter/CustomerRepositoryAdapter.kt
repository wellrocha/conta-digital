package com.wellrocha.infrastructure.database.adapter

import com.wellrocha.core.customer.application.dto.CustomerDto
import com.wellrocha.core.customer.application.port.outgoing.CustomerRepositoryPort
import com.wellrocha.infrastructure.database.entity.Customer
import com.wellrocha.infrastructure.database.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerRepositoryAdapter(private val customerRepository: CustomerRepository) : CustomerRepositoryPort {
    override fun create(fullName: String, cpf: String) : CustomerDto {
        val customer = Customer(
            fullName = fullName,
            cpf = cpf
        )

        customerRepository.insert(customer).let {
            return CustomerDto(it.id, it.fullName, it.cpf)
        }
    }

    override fun findByCpf(cpf: String) : CustomerDto? {
        customerRepository.findByCpf(cpf)?.let {
            return CustomerDto(it.id, fullName = it.fullName, cpf = it.cpf)
        }

        return null
    }
}