package com.wellrocha.core.account.application.port.outgoing

import com.wellrocha.core.account.application.dto.AccountDto

interface AccountRepositoryPort {
    fun create(email: String) : AccountDto
    fun findByEmail(email: String) : AccountDto?
}