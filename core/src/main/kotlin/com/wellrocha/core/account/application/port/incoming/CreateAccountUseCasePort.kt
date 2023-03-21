package com.wellrocha.core.account.application.port.incoming

import com.wellrocha.core.account.application.dto.AccountDto

interface CreateAccountUseCasePort {
    fun execute(email: String) : AccountDto
}