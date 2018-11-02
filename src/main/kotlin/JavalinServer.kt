import chat.ChatHandler
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import message.MessageHandler
import user.UserHandler

/**
 * This class sets up and starts the web server
 *
 * @param httpPort The port on which the web server should listen
 */
class JavalinServer (httpPort: Int) {
    // The actual web server object configured to listen on the specified sport
    private var javalin: Javalin? = Javalin.create().enableDebugLogging().enableCaseSensitiveUrls().start(httpPort)

    init {
        // Sets up the REST routes
        javalin?.routes {
            path("api") {
                path("users") {
                    post("login", UserHandler::login)
                    post("register", UserHandler::registerNew)
                }
                path(":jwt") {
                    path("users/:userId/update") {
                        post("displayName", UserHandler::setNewDisplayName)
                        post("status", UserHandler::setNewStatus)
                    }
                    path("messages") {
                        post("new", MessageHandler::newMessage)
                        path(":messageId/:chatId") {
                            delete("delete", MessageHandler::deleteMessage)
                            patch("edit", MessageHandler::editMessage)
                        }
                    }
                    path("chats") {
                        post("new", ChatHandler::newChat)
                        path(":chatId") {
                            delete("delete", ChatHandler::deleteChat)
                            path("update") {
                                patch("title", ChatHandler::updateTitle)
                                path("member/:userId") {
                                    post(ChatHandler::addMember)
                                    delete(ChatHandler::removeMember)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}