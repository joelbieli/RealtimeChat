package chat

import io.javalin.Context
import utils.Base64Utils
import utils.JWTUtils

/**
 * This singleton object holds all logic to handle chat related requests
 */
object ChatHandler {
    /**
     * Creates a new chat
     *
     * @param ctx The request
     */
    fun newChat(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.body().isBlank()) { // Checks that the request body isn't empty (i.e. that there is an actual new chat)
                val newChat = ctx.body<NewChat>() // Deserializes the body to a NewChat object
                val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

                if (decodedToken != null) {
                    newChat(newChat.toMDBChat())
                    ctx.status(201).result("Chat was created")
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
     * Deletes a chat
     *
     * @param ctx The request
     */
    fun deleteChat(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.pathParam("chatId").isBlank()) { // Checks that a chat id was provided
                val chatToDelete = Base64Utils.decodeStringToId(ctx.pathParam("chatId")) // Decodes the chat id
                val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

                if (decodedToken != null) {
                    if (deleteChat(chatToDelete)) {
                        ctx.status(200).result("Chat was deleted")
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
            ctx.status(401).result("No authentication token provided")
            return
        }
    }

    /**
     * Adds a member to a chat
     *
     * @param ctx The request
     */
    fun addMember(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.pathParam("chatId").isBlank()) { // Checks that a chat id was provided
                if (!ctx.pathParam("userId").isBlank()) { // Checks that a user id was provided
                    val userToAdd = Base64Utils.decodeStringToId(ctx.pathParam("userId")) // Decodes the user id
                    val chatToAddMember = Base64Utils.decodeStringToId(ctx.pathParam("chatId")) // Decodes the chat id
                    val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

                    if (decodedToken != null) {
                        if (addMember(chatToAddMember, userToAdd)) {
                            ctx.status(200).result("Member was successfully added")
                            return
                        } else {
                            ctx.status(500).result("There was a server-side problem adding the member")
                            return
                        }
                    } else {
                        ctx.status(401).result("Couldn't verify authenticity of requester")
                        return
                    }
                } else {
                    ctx.status(400).result("No user id provided")
                    return
                }
            } else {
                ctx.status(400).result("No chat id provided")
                return
            }
        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }

    /**
     * Removes a member from a chat
     *
     * @param ctx The request
     */
    fun removeMember(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.pathParam("chatId").isBlank()) { // Checks that a chat id was provided
                if (!ctx.pathParam("userId").isBlank()) { // Checks that a user id was provided
                    val userToAdd = Base64Utils.decodeStringToId(ctx.pathParam("userId")) // Decodes the user id
                    val chatToAddMember = Base64Utils.decodeStringToId(ctx.pathParam("chatId")) // Decodes the chat id
                    val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

                    if (decodedToken != null) {
                        if (removeMember(chatToAddMember, userToAdd)) {
                            ctx.status(200).result("Member was successfully removed")
                            return
                        } else {
                            ctx.status(500).result("There was a server-side problem removing the member")
                            return
                        }
                    } else {
                        ctx.status(401).result("Couldn't verify authenticity of requester")
                        return
                    }
                } else {
                    ctx.status(400).result("No user id provided")
                    return
                }
            } else {
                ctx.status(400).result("No chat id provided")
                return
            }
        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }

    /**
     * Updates the title of a chat
     *
     * @param ctx The request
     */
    fun updateTitle(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.pathParam("chatId").isBlank()) { // Checks that a chat id was provided
                if (!ctx.body().isBlank()) { // Checks that the request body isn't empty (i.e. that a new title was provided)
                    val updateInfo = ctx.body<Map<String, String>>() // Deserialized the body to a map
                    val chatId = Base64Utils.decodeStringToId(ctx.pathParam("chatId")) // Decodes the chat id
                    val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

                    if (decodedToken != null) {
                        if (updateInfo["newTitle"] == null) {
                            ctx.status(400).result("No title provided")
                            return
                        }
                        if (updateTitle(chatId, updateInfo["newTitle"]!!)) {
                            ctx.status(200).result("Title was successfully updated")
                            return
                        } else {
                            ctx.status(500).result("There was a server-side problem removing the member")
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
                ctx.status(400).result("No chat id provided")
                return
            }
        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }
}