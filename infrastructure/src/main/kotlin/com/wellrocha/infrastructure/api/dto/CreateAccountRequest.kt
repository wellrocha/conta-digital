package com.wellrocha.infrastructure.api.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class CreateAccountRequest(@get:NotEmpty @get:Email val email: String)
