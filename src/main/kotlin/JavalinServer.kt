import chat.ChatHandler
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import message.MessageHandler
import user.UserHandler

class JavalinServer (httpPort: Int) {
    var javalin: Javalin? = Javalin.create().enableDebugLogging().start(httpPort)

    init {
        javalin = Javalin.create().enableDebugLogging().start(httpPort)

        val userHandler = UserHandler()
        val messageHandler = MessageHandler()
        val chatHandler = ChatHandler()

        javalin?.routes {
            path("api") {
                path("users") {
                    path("login") { post(userHandler::login) }
                    path("register") { post(userHandler::registerNew) }
                    path("edit") { patch(userHandler::editUser) }
                }
                path(":jwt") {
                    path("messages") {
                        path("new") { post(messageHandler::newMessage) }
                        path("delete") { delete(messageHandler::deleteMessage) }
                        path("edit") {
                            path("") {  }
                            patch(messageHandler::editMessage)
                        }
                    }
                    path("chats") {
                        path("new") { post(chatHandler::newChat) }
                        path(":chatId") {
                            path("delete") { delete(chatHandler::deleteChat) }
                            path("edit") {
                                path("member") {
                                    path(":userId") {
                                        post(chatHandler::addMember)
                                        delete(chatHandler::removeMember)
                                    }
                                }
                                path("message") {
                                    path(":messageId") {
                                        post(chatHandler::addMessage)
                                        delete(chatHandler::removeMessage)
                                    }
                                }
                                path("title") { patch(chatHandler::updateTitle) }
                            }
                        }
                    }
                }
            }
        }
    }
}