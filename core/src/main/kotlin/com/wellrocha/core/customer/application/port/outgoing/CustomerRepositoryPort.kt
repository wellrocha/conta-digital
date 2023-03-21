package com.wellrocha.core.customer.application.port.outgoing

import com.wellrocha.core.customer.application.dto.CustomerDto

interface CustomerRepositoryPort {
    fun create(fullName: String, cpf: String): CustomerDto
    fun findByCpf(cpf: String) : CustomerDto?
}