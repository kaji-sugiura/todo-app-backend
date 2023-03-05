package com.example.todo.dto

import java.time.LocalDateTime

data class TodoListSearchResult(
    val id: Int,
    val userId: Int,
    val title: String,
    val detail: String,
    val date: LocalDateTime,
    val status: Int,
    val cratedAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
