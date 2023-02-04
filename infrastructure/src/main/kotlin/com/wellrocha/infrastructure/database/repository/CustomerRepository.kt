package com.wellrocha.infrastructure.database.repository

import com.wellrocha.core.customer.domain.entity.CustomerEntity
import com.wellrocha.infrastructure.database.entity.Customer
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<Customer, String> {
    fun findByCpf(cpf: String) : Customer?
}