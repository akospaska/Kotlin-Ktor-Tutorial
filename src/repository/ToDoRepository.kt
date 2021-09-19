package com.KtorTutorial.repository

import com.KtorTutorial.enteties.Customer
import com.KtorTutorial.enteties.CustomerName
import com.KtorTutorial.enteties.ToDo

interface ToDoRepository {
    fun getAllToDos(): List<ToDo>

    fun getToDo(id: Int): ToDo?

    fun getAllCustomer(): List<Customer>?

    fun getCustomerName(): List<CustomerName>?
}
