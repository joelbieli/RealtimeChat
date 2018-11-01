import chat.ChatHandler
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import message.MessageHandler
import user.UserHandler

class JavalinServer (httpPort: Int) {
    var javalin: Javalin? = Javalin.create().enableDebugLogging().enableCaseSensitiveUrls().start(httpPort)

    init {
        val userHandler = UserHandler()
        val messageHandler = MessageHandler()
        val chatHandler = ChatHandler()

        javalin?.routes {
            path("api") {
                path("users") {
                    post("login", userHandler::login)
                    post("register", userHandler::registerNew)
                }
                path(":jwt") {
                    path("users/:userId/update") {
                        post("displayName", userHandler::setNewDisplayName)
                        post("status", userHandler::setNewStatus)
                    }
                    path("messages") {
                        post("new", messageHandler::newMessage)
                        path(":messageId/:chatId") {
                            delete("delete", messageHandler::deleteMessage)
                            patch("edit", messageHandler::editMessage)
                        }
                    }
                    path("chats") {
                        post("new", chatHandler::newChat)
                        path(":chatId") {
                            delete("delete", chatHandler::deleteChat)
                            path("update") {
                                patch("title", chatHandler::updateTitle)
                                path("member/:userId") {
                                    post(chatHandler::addMember)
                                    delete(chatHandler::removeMember)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}