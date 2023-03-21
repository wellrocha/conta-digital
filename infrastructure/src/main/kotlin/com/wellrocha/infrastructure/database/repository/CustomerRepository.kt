package com.wellrocha.infrastructure.database.repository

import com.wellrocha.infrastructure.database.entity.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : MongoRepository<Customer, String> {
    fun findByCpf(cpf: String) : Customer?
}