package com.wellrocha.infrastructure.database.repository

import com.wellrocha.infrastructure.database.entity.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : CrudRepository<Account, UUID> {
    fun findByEmail(email: String) : Account?
}