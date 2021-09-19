package com.KtorTutorial.repository.SqlInventoryRepository

import com.KtorTutorial.enteties.InventoryItem
import com.KtorTutorial.enteties.RespondeResult

interface InventoryRepository {

    fun getAllInventoryItems(): List<InventoryItem>

    fun getInventoryItem(id: Int): InventoryItem?

    fun addNewInventoryItem(name: String): RespondeResult

    fun modifyCount(id: Int, direction: String): Boolean

    fun deleteInventryItem(id: Int): Boolean
}
