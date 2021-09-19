
package com.KtorTutorial.database

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object DbCustomerTable : Table<DBCustomerEntity>("customer") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
}
interface DBCustomerEntity : Entity<DBCustomerEntity> {
    companion object : Entity.Factory<DBCustomerEntity>()
    val id: Int
    val name: String
}


object DbCustomerNameTable : Table<DBCustomerNameEntity>("customer") {
    val name = varchar("name").bindTo { it.name }
}
interface DBCustomerNameEntity : Entity<DBCustomerNameEntity> {
    companion object : Entity.Factory<DBCustomerNameEntity>()
    val name: String
}

