package com.KtorTutorial.database

import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class DatabaseManager {
    private val hostname = "localhost"
    private val databaseName = "apitestapp"
    private val username = "root"
    private val password = "password"

    private val ktormDatabase: Database

    init {
        println("jdbc:mysql://$hostname:3306/$databaseName?user=$username&password=$password&useSSL=false")
        val jdbcUrl = "jdbc:mysql://$hostname:3306/$databaseName?user=$username&password=$password&useSSL=false&serverTimezone=UTC"
        ktormDatabase = Database.connect(jdbcUrl)
    }
    fun getAllTodos(): List<DBTodoEntity> {
        return ktormDatabase.sequenceOf(DBTodoTable).toList()
    }
}
