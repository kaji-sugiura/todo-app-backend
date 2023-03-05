package com.example.todo.service

import com.example.todo.dto.UserDTO
import com.example.todo.entity.User
import com.example.todo.exception.UserNotFoundException
import com.example.todo.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

/**
 * ユーザに関するビジネスロジックを提供する
 */
@Service
@Transactional
class UserService(val userRepository: UserRepository) {

    /**
     * ユーザ登録
     *
     * @param userDTO
     * @return User
     */
    fun register(userDTO: UserDTO): User {
        val entity = userDTO.let {
            User(null, it.name, it.email, false, LocalDateTime.now(), LocalDateTime.now())
        }
        return userRepository.save(entity)
    }

    /**
     * ユーザ1人検索
     *
     * @param userId
     * @return User
     */
    fun searchOne(userId: Int): User {
        val user = userRepository.findById(userId)
        if(user.isEmpty) {
            throw UserNotFoundException("user not found of userId $userId")
        }
        return user.get()
    }
}