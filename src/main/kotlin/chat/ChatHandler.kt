package chat

import io.javalin.Context
import org.apache.commons.codec.binary.Base64
import org.litote.kmongo.toId
import utils.verify

class ChatHandler {
    fun newChat(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.body().isBlank()) {
                val chatToAdd = ctx.body<Chat>()
                val decodedToken = verify(ctx.pathParam("jwt"))

                if (decodedToken != null) {
                    newChat(chatToAdd)
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
                val chatToDelete = Base64().decode(ctx.pathParam("chatId")).toString()
                val decodedToken = verify(ctx.pathParam("jwt"))

                if (decodedToken != null) {
                    if (deleteChat(chatToDelete.toId())) {
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
                    val userToAdd = Base64().decode(ctx.pathParam("userId")).toString().toId<String>()
                    val chatToAddMember = Base64().decode(ctx.pathParam("chatId")).toString().toId<String>()
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
                    val userToAdd = Base64().decode(ctx.pathParam("userId")).toString().toId<String>()
                    val chatToAddMember = Base64().decode(ctx.pathParam("chatId")).toString().toId<String>()
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


    //TODO: remove as this should be handled by the message handler
    fun addMessage(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {

        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }

    //TODO: remove as this should be handled by the message handler
    fun removeMessage(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {

        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }

    fun updateTitle(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("chatId").isBlank()) {
                if (!ctx.body().isBlank()) {
                    val title = ctx.bodyAsClass(AbstractMutableMap<String, String>)
                    val chatToAddMember = Base64().decode(ctx.pathParam("chatId")).toString().toId<String>()
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