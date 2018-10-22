package user

import io.javalin.Context
import mdbcl
import org.litote.kmongo.eq
import org.litote.kmongo.findOne

class UserHandler {
    fun registerNewUser(ctx: Context) {
        val newUserData = ctx.body<NewUser>()
        val existingUser = mdbcl.users.findOne(User::email eq newUserData.email)
        if (existingUser == null) {
            newUser(User.Mapper.from(newUserData))
            ctx.json(FrontendUser.Mapper.from(newUserData))
        } else {
            if (existingUser.checkPW(newUserData.password)) {
                ctx.json(FrontendUser.Mapper.from(newUserData))
            }
        }
        ctx.status(409).result("The user already exists")
    }
}
