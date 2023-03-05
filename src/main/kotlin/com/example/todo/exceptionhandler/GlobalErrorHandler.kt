package com.example.todo.exceptionhandler

import com.example.todo.exception.TodoNotFoundException
import com.example.todo.exception.UserNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Component
@ControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val errors = ex.bindingResult.allErrors
            .map { error -> error.defaultMessage!! }
            .sorted()
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                errors.joinToString(",") { it }
            )
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleInputRequestError(ex: UserNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ex.message
            )
    }

    @ExceptionHandler(TodoNotFoundException::class)
    fun handleInputRequestError(ex: TodoNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ex.message
            )
    }

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: java.lang.Exception, request: WebRequest): ResponseEntity<Any> {
        logger.info("Exception occurred: ${ex.message} on request: $request", ex)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ex.message
            )
    }
}