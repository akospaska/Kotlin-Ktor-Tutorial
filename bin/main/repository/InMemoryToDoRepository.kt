package com.KtorTutorial.repository

import com.KtorTutorial.enteties.Customer
import com.KtorTutorial.enteties.CustomerName
import com.KtorTutorial.enteties.ToDo

class InMemoryToDoRepository : ToDoRepository {

    private val todos = listOf<ToDo>(ToDo(1, "Plan content for video", false), ToDo(2, "2 Plan content for video", false), ToDo(3, "3 Plan content for video", false))

    override fun getAllToDos(): List<ToDo> {
        return todos
    }

    override fun getToDo(id: Int): ToDo? {
        return todos.firstOrNull { it.id == id }
    }

    override fun getAllCustomer(): List<Customer>? {
        TODO("Not yet implemented")
    }

    override fun getCustomerName(): List<CustomerName>? {
        TODO("Not yet implemented")
    }
}
