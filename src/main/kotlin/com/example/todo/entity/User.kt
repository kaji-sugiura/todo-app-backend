package com.example.todo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

/**
 * ユーザEntity
 */
@Entity
@Table(name = "USER")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val name: String,
    val email: String,
    val deleted: Boolean,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
)