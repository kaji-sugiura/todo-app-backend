package com.example.todo.service

import com.example.todo.dto.TodoDTO
import com.example.todo.dto.TodoListSearchQuery
import com.example.todo.dto.TodoListSearchResult
import com.example.todo.entity.Todo
import com.example.todo.exception.TodoNotFoundException
import com.example.todo.repository.TodoMapper
import com.example.todo.repository.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

/**
 * Todoに関するビジネスロジックを提供するクラス
 */
@Service
@Transactional
class TodoService(val todoRepository: TodoRepository, val userService: UserService, val todoMapper: TodoMapper) {

    /**
     * Todo新規登録
     *
     * @param userId
     * @param todoDTO
     * @return TodoEntity
     */
    fun register(userId: Int, todoDTO: TodoDTO): Todo {
        val user = userService.searchOne(userId)
        val entity = todoDTO.let {
            Todo(null, it.title, it.detail, it.date, 0, LocalDateTime.now(), LocalDateTime.now(), user)
        }
        return todoRepository.save(entity)
    }

    /**
     * Todo一覧検索
     *
     * @param query 検索クエリ
     * @return Todo一覧
     */
    fun searchTodoList(query: TodoListSearchQuery): List<TodoListSearchResult> {
        return todoMapper.searchTodoList(query)
    }

    /**
     * 1件検索
     *
     * 指定のidのデータが存在しない場合、例外をスローする。
     *
     * @param id
     * @return Todo
     */
    fun findById(id: Int): Todo {
        val entity = todoRepository.findById(id)
        if(entity.isEmpty) {
            throw TodoNotFoundException("todo not found of id $id")
        }
        return entity.get()
    }

    /**
     * Todo更新
     *
     * @param id
     * @param todoDTO
     * @return Todo
     */
    fun update(id: Int, todoDTO: TodoDTO): Todo {
        val entity = findById(id).let {
            Todo(id, todoDTO.title, todoDTO.detail, todoDTO.date, it.status, it.createdAt, LocalDateTime.now(), it.user)
        }
        return todoRepository.save(entity)
    }
}