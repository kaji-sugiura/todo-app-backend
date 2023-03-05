package com.example.todo.controller

import com.example.todo.dto.UserDTO
import com.example.todo.entity.User
import com.example.todo.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * ユーザController
 */
@RestController
@RequestMapping("/api/v1/user")
@Validated
class UserController(val userService: UserService) {

    /**
     * ユーザ登録API
     *
     * @param userDTO
     * @return User 登録したユーザEntity
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody @Valid userDTO: UserDTO): User = userService.register(userDTO)

    /**
     * ユーザ検索API
     *
     * @param userId 検索するユーザID
     * @return User 検索対象のユーザEntity
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun searchUser(@PathVariable("id") userId: Int): User {
        return userService.searchOne(userId)
    }
}