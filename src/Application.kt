package com.KtorTutorial

import com.KtorTutorial.enteties.InventoryItem
import com.KtorTutorial.enteties.RespondeResult
import com.KtorTutorial.repository.SqlInventoryRepository.InventoryRepository
import com.KtorTutorial.repository.SqlInventoryRepository.MySQLInventoryRepository
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.jackson.jackson
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads

fun Application.module(testing: Boolean = false) {
    data class Customer(val name: String, val age: Int)

    install(CORS) {
        anyHost()
        method(HttpMethod.Options)
        method(HttpMethod.Get)
        method(HttpMethod.Post)
        header("authorization")
        allowCredentials = true
        allowNonSimpleContentTypes = true
    }
    install(CallLogging)

    install(ContentNegotiation) {
        gson()
        jackson()
    }

    routing {
        static("/static") {
            resources("files")
        }
        val inventoryRepository: InventoryRepository = MySQLInventoryRepository()

        // inventoryEndpoints

        get("/getinventorylist") {
            call.respond(listOf(inventoryRepository.getAllInventoryItems()))
        }
        post("/post") {
            var request = call.receive<Request>()
            request.id = request.id + 1
            call.respond(listOf(request))
        }
        post("/getinventorybyid") {
            var request = call.receive<RequestById>()
            val targetElement: InventoryItem? = inventoryRepository.getInventoryItem(request.id)
            println(targetElement)
            call.respond(listOf(targetElement))
        }
        post("/addnewinventoryitem") {
            var request = call.receive<addnewItemRequest>()
            val res: RespondeResult = inventoryRepository.addNewInventoryItem(request.name)
            call.respond(listOf(res))
        }
        post("/modifycount") {
            var request = call.receive<updateCount>()
            val res = inventoryRepository.modifyCount(request.id, request.direction)
            call.respond(listOf(res))
        }
        post("/deleteinventoryitem") {
            var request = call.receive<deleteInventoryRequestBody>()
            val res = inventoryRepository.deleteInventryItem(request.id)
            call.respond(listOf(res))
        }
    }
}

data class Request(var id: Int, val name: String)

data class RequestById(var id: Int)

data class addnewItemRequest(val name: String)

data class updateCount(val id: Int, val direction: String)

data class deleteInventoryRequestBody(val id: Int)
