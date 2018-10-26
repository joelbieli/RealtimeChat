package message

import io.javalin.Context

class MessageHandler {
    fun newMessage(ctx: Context) {
        if (!ctx.body().isBlank()) {

        } else {
            ctx.status(400).result("No request body found")
        }
    }

    fun deleteMessage(ctx: Context) {
        if (!ctx.body().isBlank()) {

        } else {
            ctx.status(400).result("No request body found")
        }
    }

    fun editMessage(ctx: Context) {
        if (!ctx.body().isBlank()) {

        } else {
            ctx.status(400).result("No request body found")
        }
    }
}