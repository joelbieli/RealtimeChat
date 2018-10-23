package user

import io.javalin.Context
import mdbcl
import org.litote.kmongo.eq
import org.litote.kmongo.findOne

class UserHandler {
    fun registerNew(ctx: Context) {
        if (!ctx.body().isBlank()) {
            val newUserData = ctx.body<User>()
            val existingUser = mdbcl.users.findOne(User::email eq newUserData.email)

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
            val newUserData = ctx.body<User>()
            val existingUser = mdbcl.users.findOne(User::email eq newUserData.email)

            if (existingUser != null) {
                if (existingUser.checkPW(newUserData.password)) {
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

    fun getUserInfo(ctx: Context) {

    }
}
