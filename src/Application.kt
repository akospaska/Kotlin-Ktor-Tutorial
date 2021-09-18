package com.KtorTutorial

import com.KtorTutorial.enteties.ToDo
import com.KtorTutorial.repository.InMemoryToDoRepository
import com.KtorTutorial.repository.MySQLTodoRepository
import com.KtorTutorial.repository.ToDoRepository
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.http.cio.*
import io.ktor.jackson.jackson
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    data class Customer(val name: String, val age: Int)

    install(CallLogging)
    install(ContentNegotiation) {
        gson()
        jackson()
    }

    routing {

        val repository: ToDoRepository = MySQLTodoRepository()

        get("/") {
            call.respond(repository.getAllToDos())
        }

        post("/todosbyid") {
            val requestBody = call.receive<requestTodoListById>()
            val targetedToDo: ToDo? = repository.getToDo(requestBody.id)
            call.respond(listOf(targetedToDo))
        }
        get("/todos/{id}") {
            var id: Int? = call.parameters["id"]?.toIntOrNull()

            if (id != null) {
                var somet: ToDo? = repository.getToDo(id)

                call.respond(listOf(somet))
            } else {
                call.respond(HttpStatusCode.BadRequest, message = "Id parameter has to be a number")
            }
        }
        post("/todos") {
            //  val parameters = call.receiveParameters()

            call.respondText("asdasd")
        }
        put("/todos/{id}") {
        }
        delete("/todos/{id}") {
        }
        post("/post") {
            var request = call.receive<Request>()
            println(request)
            request.id = "ModifiedID"
            call.respond(listOf(request))
        }
    }
}

data class requestTodoListById(val id: Int)
data class Request(
    var id: String,
    val quantity: Int,
    val isTrue: Boolean
)

data class Response(val status: String)
