package com.example.todo.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

/**
 * ユーザDTO
 */
data class UserDTO (

    @field:NotBlank(message = "name must not be blank")
    val name: String,
    @field:NotBlank(message = "email must not be blank")
    @field:Email(message = "The format of Email is incorrect")
    val email: String
)