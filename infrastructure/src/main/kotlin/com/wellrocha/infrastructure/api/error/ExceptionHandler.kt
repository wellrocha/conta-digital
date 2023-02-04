package com.wellrocha.infrastructure.api.error

import com.wellrocha.core.customer.domain.error.AlreadyExistsException
import com.wellrocha.core.customer.domain.error.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(AlreadyExistsException::class)
    fun handleAlreadyExistsException(exception: AlreadyExistsException): ResponseEntity<Any> =
        ApiError(status = HttpStatus.CONFLICT, exception.message).let {
            ResponseEntity(it, HttpHeaders(), it.status)
        }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException): ResponseEntity<Any> =
        ApiError(status = HttpStatus.NOT_FOUND, exception.message).let {
            ResponseEntity(it, HttpHeaders(), it.status)
        }

    override fun handleMethodArgumentNotValid(
        exception: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val errors = mutableListOf<String>()

        exception.bindingResult.fieldErrors.forEach { errors.add("${it.field}: ${it.defaultMessage}") }
        exception.bindingResult.globalErrors.forEach { errors.add("${it.objectName}: ${it.defaultMessage}") }

        val apiError = ApiError(HttpStatus.BAD_REQUEST, errors)
        return handleExceptionInternal(exception, apiError, headers, apiError.status, request)
    }
}