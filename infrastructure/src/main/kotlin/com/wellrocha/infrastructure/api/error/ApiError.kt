package com.wellrocha.infrastructure.api.error

import org.springframework.http.HttpStatus

data class ApiError(
    val status: HttpStatus,
    val errors: List<String?>
){
    constructor(status: HttpStatus, error: String?) : this(status, arrayListOf<String?>(error))
    constructor(status: HttpStatus) : this(status, arrayListOf<String>())
}
