package chat

import io.javalin.Context
import utils.Base64Utils
import utils.verify

class ChatHandler {
    fun newChat(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.body().isBlank()) {
                val newChat = ctx.body<NewChat>()
                val decodedToken = verify(ctx.pathParam("jwt"))

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

    fun deleteChat(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("chatId").isBlank()) {
                val chatToDelete = Base64Utils.decodeStringToId(ctx.pathParam("chatId"))
                val decodedToken = verify(ctx.pathParam("jwt"))

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

    fun addMember(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("chatId").isBlank()) {
                if (!ctx.pathParam("userId").isBlank()) {
                    val userToAdd = Base64Utils.decodeStringToId(ctx.pathParam("userId"))
                    val chatToAddMember = Base64Utils.decodeStringToId(ctx.pathParam("chatId"))
                    val decodedToken = verify(ctx.pathParam("jwt"))

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

    fun removeMember(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("chatId").isBlank()) {
                if (!ctx.pathParam("userId").isBlank()) {
                    val userToAdd = Base64Utils.decodeStringToId(ctx.pathParam("userId"))
                    val chatToAddMember = Base64Utils.decodeStringToId(ctx.pathParam("chatId"))
                    val decodedToken = verify(ctx.pathParam("jwt"))

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

    fun updateTitle(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("chatId").isBlank()) {
                if (!ctx.body().isBlank()) {
                    val updateInfo = ctx.body<Map<String, String>>()
                    val chatId = Base64Utils.decodeStringToId(ctx.pathParam("chatId"))
                    val decodedToken = verify(ctx.pathParam("jwt"))

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