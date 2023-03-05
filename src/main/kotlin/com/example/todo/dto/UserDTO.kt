package com.example.todo.dto

import jakarta.validation.constraints.NotBlank

/**
 * ユーザDTO
 */
data class UserDTO (

    @field:NotBlank(message = "name must not be blank")
    val name: String,
    @field:NotBlank(message = "email must not be blank")
    val email: String
)