package com.wellrocha.infrastructure.database.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Entity
class Account(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID,

    var email: String,
    var balance: BigDecimal,

    @Column(name = "created_at")
    var createdAt: Instant = Instant.now(),

    @Column(name = "updated_at")
    var updatedAt: Instant = Instant.now(),
)