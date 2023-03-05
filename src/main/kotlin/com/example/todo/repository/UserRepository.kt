package com.example.todo.repository

import com.example.todo.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * ユーザレポジトリ
 */
@Repository
interface UserRepository : CrudRepository<User, Int> {
}