package com.KtorTutorial.repository

import com.KtorTutorial.enteties.ToDo

interface ToDoRepository {
    fun getAllToDos(): List<ToDo>

    fun getToDo(id: Int): ToDo?
}
