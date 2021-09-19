package com.KtorTutorial.repository

import com.KtorTutorial.database.DatabaseManager
import com.KtorTutorial.enteties.Customer
import com.KtorTutorial.enteties.CustomerName
import com.KtorTutorial.enteties.ToDo

class MySQLTodoRepository : ToDoRepository {

    private val database = DatabaseManager()

    override fun getAllToDos(): List<ToDo> {
        return database.getAllTodos().map { ToDo(it.id, it.title, it.done) }
    }

    override fun getToDo(id: Int): ToDo? {
        TODO("Not yet implemented")
    }
    override fun getAllCustomer(): List<Customer>? {
        return database.getAllCustomer().map { Customer(it.id, it.name) }
    }

    override fun getCustomerName(): List<CustomerName>? {
        return database.getAllCustomer().map { CustomerName( it.name) }
    }
}
