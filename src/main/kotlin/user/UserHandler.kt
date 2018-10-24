package user

import io.javalin.Context
import io.jsonwebtoken.Jws
import mdbcl
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import utils.verify

class UserHandler {
    fun registerNew(ctx: Context) {
        if (!ctx.body().isBlank()) {
            val newUserData = ctx.body<User>()
            val existingUser = findUserByEmail(newUserData)

            if (existingUser == null) {
                newUser(newUserData)
                ctx.status(201).json(newUserData.toResponseUser())
                return
            } else {
                if (existingUser.checkPW(newUserData.password)) {
                    ctx.status(200).json(newUserData.toResponseUser())
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
            val userToLogIn = ctx.body<User>()
            val existingUser = findUserByEmail(userToLogIn)

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

    fun editUser(ctx: Context) {
        if (!ctx.body().isBlank()) {
            val alteredUser = ctx.body<User>()
            val decodedToken = verify(alteredUser.jwt)

            if (decodedToken != null) {
                updateUser(alteredUser)
                ctx.status(200).result("User successfully updated")
            } else {
                ctx.status(401).result("Couldn't verify authenticity of requester")
            }

            ctx.status(400).result("Invalid password")
        } else {
            ctx.status(400).result("No request body found")
        }
    }
}
