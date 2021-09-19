package com.KtorTutorial.enteties

data class InventoryItem(
    val id: Int,
    val name: String,
    val count: Int
)

data class RespondeResult(val success: Boolean)
