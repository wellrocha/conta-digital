package com.wellrocha.infrastructure.database.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class Customer(
    @Id
    val id: String = ObjectId.get().toString(),

    val fullName: String,
    val cpf: String,
    val createdDate: Instant = Instant.now(),
    val modifiedDate: Instant = Instant.now()
)
