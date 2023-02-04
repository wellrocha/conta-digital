package com.wellrocha.core.customer.application.port.incoming

import com.wellrocha.core.customer.domain.entity.CustomerEntity

interface CreateCustomerUseCasePort {
    fun execute(fullName: String, cpf: String): CustomerEntity
}