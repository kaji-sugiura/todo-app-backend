package com.example.todo.controller

import com.example.todo.dto.TodoDTO
import com.example.todo.dto.TodoListSearchParam
import com.example.todo.dto.TodoListSearchQuery
import com.example.todo.dto.TodoListSearchResult
import com.example.todo.entity.Todo
import com.example.todo.service.TodoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local

/**
 * TodoController
 */
@RestController
@RequestMapping("/api/v1/todo")
class TodoController(val todoService: TodoService) {

    /**
     * Todo新規登録API
     */
    @PostMapping("/create/{user_id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun createTodo(@PathVariable("user_id") userId: Int, @Valid @RequestBody todoDTO: TodoDTO): Todo = todoService.register(userId, todoDTO)

    /**
     * Todo一覧取得API
     */
    @GetMapping("/list/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    fun searchTodoList(@PathVariable("user_id") userId: Int, @Valid @RequestBody param: TodoListSearchParam): List<TodoListSearchResult> {
        val query = param.let {
            TodoListSearchQuery(userId, it.searchFrom, it.searchTo, it.title, it.done)
        }
        return todoService.searchTodoList(query)
    }
}