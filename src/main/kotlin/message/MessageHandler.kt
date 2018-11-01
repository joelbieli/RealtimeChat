package message

import chat.addMessage
import chat.removeMessage
import io.javalin.Context
import utils.Base64Utils
import utils.verify

class MessageHandler {
    fun newMessage(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.body().isBlank()) {
                val newMessage = ctx.body<NewMessage>().toMDBMessage()
                val decodedToken = verify(ctx.pathParam("jwt"))

                if (decodedToken != null) {
                    newMessage(newMessage)
                    addMessage(newMessage.chatId, newMessage._id)
                    ctx.status(201).result("Message was created")
                    return
                } else {
                    ctx.status(401).result("Couldn't verify authenticity of requester")
                    return
                }
            } else {
                ctx.status(400).result("No request body found")
                return
            }
        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }

    fun deleteMessage(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("messageId").isBlank()) {
                if (!ctx.pathParam("chatId").isBlank()) {
                    val chatToRemoveMessageFrom = Base64Utils.decodeStringToId(ctx.pathParam("chatId"))
                    val messageToDelete = Base64Utils.decodeStringToId(ctx.pathParam("messageId"))
                    val decodedToken = verify(ctx.pathParam("jwt"))

                    if (decodedToken != null) {
                        if (deleteMessage(messageToDelete)) {
                            removeMessage(chatToRemoveMessageFrom, messageToDelete)
                            ctx.status(200).result("Message was deleted")
                            return
                        } else {
                            ctx.status(500).result("There was a server-side problem deleting the chat")
                            return
                        }
                    } else {
                        ctx.status(401).result("Couldn't verify authenticity of requester")
                        return
                    }
                } else {
                    ctx.status(400).result("No chat id provided")
                    return
                }
            } else {
                ctx.status(400).result("No message id provided")
                return
            }
        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }

    fun editMessage(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("messageId").isBlank()) {
                if (!ctx.body().isBlank()) {
                    val updateInfo = ctx.body<Map<String, String>>()
                    val messageToUpdate = Base64Utils.decodeStringToId(ctx.pathParam("chatId"))
                    val decodedToken = verify(ctx.pathParam("jwt"))

                    if (decodedToken != null) {
                        if (updateInfo["newMessage"] == null) {
                            ctx.status(400).result("No message update provided")
                            return
                        }
                        if (updateMessage(messageToUpdate, updateInfo["newMessage"]!!)) {
                            ctx.status(200).result("Message was updated")
                            return
                        } else {
                            ctx.status(500).result("There was a server-side problem deleting the chat")
                            return
                        }
                    } else {
                        ctx.status(401).result("Couldn't verify authenticity of requester")
                        return
                    }
                } else {
                    ctx.status(400).result("No request body found")
                    return
                }
            } else {
                ctx.status(400).result("No message id provided")
                return
            }
        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }
}