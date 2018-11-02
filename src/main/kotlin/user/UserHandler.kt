package user

import io.javalin.Context
import utils.Base64Utils
import utils.JWTUtils

object UserHandler {
    /**
     * Register a new user and log in
     *
     * @param ctx The request
     */
    fun registerNew(ctx: Context) {
        if (!ctx.body().isBlank()) { // Checks that the request body isn't empty (i.e. that there is an actual new user)
            val newUserData = ctx.body<MDBUser>() // Deserializes the body to a MDBUser object
            val existingUser = findUserByEmail(newUserData.email) //Check if the user already exists

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

    /**
     * Log in as an existing user
     *
     * @param ctx The request
     */
    fun login(ctx: Context) {
        if (!ctx.body().isBlank()) { // Checks that the request body isn't empty (i.e. that login data was provided)
            val userToLogIn = ctx.body<MDBUser>() // Deserializes the body to a MDBUser object
            val existingUser = findUserByEmail(userToLogIn.email) //Check if the user actually exists

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

    /**
     * Update the display name of a user
     *
     * @param ctx The request
     */
    fun setNewDisplayName(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.pathParam("userId").isBlank()) { // Checks that a user id was provided
                if (!ctx.body().isBlank()) { // Checks that the request body isn't empty (i.e. that a new display name was provided)
                    val updateInfo = ctx.body<Map<String, String>>() // Deserialized the body to a map
                    val userToUpdate = Base64Utils.decodeStringToId(ctx.pathParam("userId")) // Decodes the user id
                    val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

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

    /**
     * Update the status of a user
     *
     * @param ctx The request
     */
    fun setNewStatus(ctx: Context) {
        if (!ctx.pathParam("jwt").isBlank()) { // Checks that there is a authentication token
            if (!ctx.pathParam("userId").isBlank()) { // Checks that a user id was provided
                if (!ctx.body().isBlank()) { // Checks that the request body isn't empty (i.e. that a new status was provided)
                    val updateInfo = ctx.body<Map<String, String>>() // Deserialized the body to a map
                    val userToUpdate = Base64Utils.decodeStringToId(ctx.pathParam("userId")) // Decodes the user id
                    val decodedToken = JWTUtils.verify(ctx.pathParam("jwt")) // Verifies the requesters identity

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
