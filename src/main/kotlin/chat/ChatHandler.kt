package chat

import io.javalin.Context

class ChatHandler {
    fun newChat(ctx: Context) {
        if (!ctx.body().isBlank()) {

        } else {
            ctx.status(400).result("No request body found")
        }
    }

    fun deleteChat(ctx: Context) {
        if (!ctx.body().isBlank()) {

        } else {
            ctx.status(400).result("No request body found")
        }
    }

    fun editChat(ctx: Context) {
        if (!ctx.body().isBlank()) {

        } else {
            ctx.status(400).result("No request body found")
        }
    }
}