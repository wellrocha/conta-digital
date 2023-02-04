package com.wellrocha.core.customer.application.port.outgoing

import com.wellrocha.core.customer.domain.entity.CustomerEntity

interface CustomerRepositoryPort {
    fun create(fullName: String, cpf: String): CustomerEntity
    fun findByCpf(cpf: String) : CustomerEntity?
}