package user

import io.javalin.Context
import utils.Base64Utils
import utils.verify

class UserHandler {
    fun registerNew(ctx: Context) {
        if (!ctx.body().isBlank()) {
            val newUserData = ctx.body<MDBUser>()
            val existingUser = findUserByEmail(newUserData.email)

            if (existingUser == null) {
                newUser(newUserData)
                ctx.status(201).json(findUserById(newUserData._id)?.toResponseUser()!!)
                return
            } else {
                if (existingUser.checkPW(newUserData.password)) {
                    ctx.status(200).json(findUserByEmail(newUserData.email)?.toResponseUser()!!)
                    return
                }
            }

            ctx.status(409).result("The user already exists")
        } else {
            ctx.status(400).result("No request body found")
        }
    }

    fun login(ctx: Context) {
        if (!ctx.body().isBlank()) {
            val userToLogIn = ctx.body<MDBUser>()
            val existingUser = findUserByEmail(userToLogIn.email)

            if (existingUser != null) {
                if (existingUser.checkPW(userToLogIn.password)) {
                    ctx.status(200).json(existingUser.toResponseUser())
                    return
                }
            } else {
                ctx.status(404).result("No user with email found")
                return
            }

            ctx.status(400).result("Invalid password")
        } else {
            ctx.status(400).result("No request body found")
        }
    }

    fun setNewDisplayName(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("userId").isBlank()) {
                if (!ctx.body().isBlank()) {
                    val updateInfo = ctx.body<Map<String, String>>()
                    val userToUpdate = Base64Utils.decodeStringToId(ctx.pathParam("userId"))
                    val decodedToken = verify(ctx.pathParam("jwt"))

                    if (decodedToken != null) {
                        if (updateInfo["newDisplayName"] == null) {
                            ctx.status(400).result("No display name provided")
                            return
                        }
                        if (updateDisplayName(userToUpdate, updateInfo["newDisplayName"]!!)) {
                            ctx.status(200).result("Display name was successfully updated")
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
                ctx.status(400).result("No user id provided")
                return
            }
        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }

    fun setNewStatus(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) {
            if (!ctx.pathParam("userId").isBlank()) {
                if (!ctx.body().isBlank()) {
                    val updateInfo = ctx.body<Map<String, String>>()
                    val userToUpdate = Base64Utils.decodeStringToId(ctx.pathParam("userId"))
                    val decodedToken = verify(ctx.pathParam("jwt"))

                    if (decodedToken != null) {
                        if (updateInfo["newStatus"] == null) {
                            ctx.status(400).result("No status provided")
                            return
                        }
                        if (updateStatus(userToUpdate, updateInfo["newStatus"]!!)) {
                            ctx.status(200).result("Status was successfully updated")
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
                ctx.status(400).result("No user id provided")
                return
            }
        } else {
            ctx.status(401).result("No authentication token provided")
            return
        }
    }
}
