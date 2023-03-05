package com.example.todo.dto

import java.time.LocalDateTime

/**
 * Todo一覧取得パラメータ
 */
data class TodoListSearchParam(
    val searchFrom: LocalDateTime?,
    val searchTo: LocalDateTime?,
    val title: String?,
    val done: Int?
)
