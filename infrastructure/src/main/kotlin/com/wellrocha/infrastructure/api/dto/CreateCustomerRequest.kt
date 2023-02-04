package com.wellrocha.infrastructure.api.dto

import jakarta.validation.constraints.NotEmpty

data class CreateCustomerRequest(@get:NotEmpty val fullName: String, @get:NotEmpty val cpf: String)
