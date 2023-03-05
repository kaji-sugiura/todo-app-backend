package com.example.todo.repository

import com.example.todo.entity.Todo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Todoリポジトリ
 */
@Repository
interface TodoRepository : CrudRepository<Todo, Int> {
}