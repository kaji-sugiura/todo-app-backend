package com.example.todo.repository

import com.example.todo.dto.TodoListSearchQuery
import com.example.todo.dto.TodoListSearchResult
import org.apache.ibatis.annotations.Mapper

@Mapper
interface TodoMapper {
    fun searchTodoList(query:TodoListSearchQuery): List<TodoListSearchResult>
}