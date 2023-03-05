package com.example.todo.dto

import java.time.LocalDateTime

/**
 * Todo一覧検索クエリ
 */
data class TodoListSearchQuery(
    val userId: Int,
    val searchFrom: LocalDateTime?,
    val searchTo: LocalDateTime?,
    val title: String?,
    val done: Int?
)
