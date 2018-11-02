package message

import chat.addMessage
import chat.removeMessage
import io.javalin.Context
import utils.Base64Utils
import utils.JWTUtils

/**
 * This singleton object holds all logic to handle message related requests
 */
object MessageHandler {
    /**
     * Creates a new message
     *
     * @param ctx The request
     */
    fun newMessage(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.body().isBlank()) { // Checks that the request body isn't empty (i.e. that there is an actual new message)
                val newMessage = ctx.body<NewMessage>().toMDBMessage() // Deserializes the body to a NewMessage object
                val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

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

    /**
     * Deletes a message
     *
     * @param ctx The request
     */
    fun deleteMessage(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.pathParam("messageId").isBlank()) { // Checks that a message id was provided
                if (!ctx.pathParam("chatId").isBlank()) { // Checks that a chat id was provided
                    val chatToRemoveMessageFrom = Base64Utils.decodeStringToId(ctx.pathParam("chatId")) // Decodes the chat id
                    val messageToDelete = Base64Utils.decodeStringToId(ctx.pathParam("messageId")) // Decodes the message id
                    val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

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

    /**
     * Updates the content of a message
     *
     * @param ctx The request
     */
    fun editMessage(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.pathParam("messageId").isBlank()) { // Checks that a message id was provided
                if (!ctx.body().isBlank()) { // Checks that the request body isn't empty (i.e. that a new message content was provided)
                    val updateInfo = ctx.body<Map<String, String>>() // Deserialized the body to a map
                    val messageToUpdate = Base64Utils.decodeStringToId(ctx.pathParam("chatId")) // Decodes the chat id
                    val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

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