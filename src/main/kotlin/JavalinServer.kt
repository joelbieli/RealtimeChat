import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post
import user.UserHandler

class JavalinServer (httpPort: Int) {
    var javalin: Javalin? = null

    init {
        javalin = Javalin.create().enableDebugLogging().start(httpPort)

        val userHandler = UserHandler()

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
                        post(userHandler::editUser)
                    }
                }
            }
        }
    }
}