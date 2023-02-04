package com.wellrocha.infrastructure.database.adapter

import com.wellrocha.core.customer.application.port.outgoing.CustomerRepositoryPort
import com.wellrocha.core.customer.domain.entity.CustomerEntity
import com.wellrocha.infrastructure.database.entity.Customer
import com.wellrocha.infrastructure.database.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerRepositoryAdapter(private val customerRepository: CustomerRepository) : CustomerRepositoryPort {
    override fun create(fullName: String, cpf: String) : CustomerEntity {
        val customer = Customer(
            fullName = fullName,
            cpf = cpf
        )

        customerRepository.insert(customer).let {
            return CustomerEntity(it.id, it.fullName, it.cpf)
        }
    }
    override fun findByCpf(cpf: String) : CustomerEntity? {
        customerRepository.findByCpf(cpf)?.let {
            return CustomerEntity(it.id, fullName = it.fullName, cpf = it.cpf)
        }

        return null
    }
}