package com.example.todo.entity

import jakarta.persistence.*
import java.time.LocalDateTime

/**
 * Todo Entity
 */
@Entity
@Table(name = "TODO")
data class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val title: String,
    val detail: String,
    val date: LocalDateTime,
    val status: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id", nullable = false)
    val user: User
)
