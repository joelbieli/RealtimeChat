import chat.ChatHandler
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import message.MessageHandler
import user.UserHandler

class JavalinServer (httpPort: Int) {
    var javalin: Javalin? = null

    init {
        javalin = Javalin.create().enableDebugLogging().start(httpPort)

        val userHandler = UserHandler()
        val messageHandler = MessageHandler()
        val chatHandler = ChatHandler()

        javalin?.routes {
            path("api") {
                path("users") {
                    path("login") {
                        post(userHandler::login)
                    }
                    path("register") {
                        post(userHandler::registerNew)
                    }
                    path("edit") {
                        patch(userHandler::editUser)
                    }
                }
                path("messages") {
                    path("new") {
                        post(messageHandler::newMessage)
                    }
                    path("delete") {
                        delete(messageHandler::deleteMessage)
                    }
                    path("edit") {
                        patch(messageHandler::editMessage)
                    }
                }
                path("chats") {
                    path("new") {
                        post(chatHandler::newChat)
                    }
                    path("delete") {
                        delete(chatHandler::deleteChat)
                    }
                    path("edit") {
                        patch(chatHandler::editChat)
                    }
                }
            }
        }
    }
}