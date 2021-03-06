package com.KtorTutorial.repository.SqlInventoryRepository

import com.KtorTutorial.database.DatabaseManager
import com.KtorTutorial.enteties.InventoryItem
import com.KtorTutorial.enteties.RespondeResult

class MySQLInventoryRepository : InventoryRepository {

    private val database = DatabaseManager()

    override fun getAllInventoryItems(): List<InventoryItem> {
        return database.getAllInventoryItems().map { InventoryItem(it.id, it.name, it.count) }
    }

    override fun getInventoryItem(id: Int): InventoryItem? {
        return database.getInventoryItem(id)?.let { InventoryItem(it.id, it.name, it.count) }
    }

    override fun addNewInventoryItem(name: String): RespondeResult {

       return database.addNewInventoryItem(name)?.let {RespondeResult(true)}
    }

    override fun modifyCount(id: Int, direction: String): Boolean {
        return database.modifyCount(id,direction)
    }

    override fun deleteInventryItem(id: Int): Boolean {
       return database.deleteInventryItem(id)
    }
}
