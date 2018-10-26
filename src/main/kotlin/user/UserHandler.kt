package user

import io.javalin.Context
import io.jsonwebtoken.Jws
import mdbcl
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.util.idValue
import utils.verify

class UserHandler {
    fun registerNew(ctx: Context) {
        if (!ctx.body().isBlank()) {
            val newUserData = ctx.body<User>()
            val existingUser = findUserByEmail(newUserData.email)

            if (existingUser == null) {
                newUser(newUserData)
                ctx.status(201).json(findUserByEmail(newUserData.email)?.toResponseUser()!!)
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
        println(ctx.ip())

        if (!ctx.body().isBlank()) {
            val userToLogIn = ctx.body<User>()
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

    fun editUser(ctx: Context) {
        if (!ctx.body().isBlank()) {
            val alteredUser = ctx.body<User>()
            val decodedToken = verify(alteredUser.jwt)

            if (decodedToken != null) {
                val oldUser = findUserById(decodedToken.body.subject)
                val updatedUser = updateUser(alteredUser, oldUser!!)
                if (updatedUser != null) {
                    ctx.status(200).json(updatedUser)
                } else {
                    ctx.status(500).result("There was a problem updating the user document in the database.")
                }
                return
            } else {
                ctx.status(401).result("Couldn't verify authenticity of requester")
                return
            }
        } else {
            ctx.status(400).result("No request body found")
        }
    }
}
