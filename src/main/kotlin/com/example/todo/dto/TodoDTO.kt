package com.example.todo.dto

import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

/**
 * Todo DTO
 */
data class TodoDTO(
    @field: NotBlank(message = "title must not be blank")
    val title: String,
    @field: NotBlank(message = "detail must not be blank")
    val detail: String,
    @field: NotNull(message = "date must not be blank")
    @field: FutureOrPresent(message = "date must be today or future")
    val date: LocalDateTime
)
