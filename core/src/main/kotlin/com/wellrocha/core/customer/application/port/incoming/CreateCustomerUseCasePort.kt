package com.wellrocha.core.customer.application.port.incoming

import com.wellrocha.core.customer.application.dto.CustomerDto

interface CreateCustomerUseCasePort {
    fun execute(fullName: String, cpf: String): CustomerDto
}