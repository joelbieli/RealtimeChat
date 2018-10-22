package user

import org.litote.kmongo.Id
import org.litote.kmongo.newId
import org.mindrot.jbcrypt.BCrypt

class User (
        var _id: Id<String>,
        var firstName: String,
        var lastName: String,
        var displayName: String,
        var status: String,
        var email: String,
        password: String
) {
    var hash: String = BCrypt.hashpw(password, BCrypt.gensalt())

    fun checkPW(pw: String): Boolean {
        return BCrypt.checkpw(hash, pw)
    }

    object Mapper {
        fun from(newUser: NewUser) = User(
                newId(),
                newUser.firstName,
                newUser.lastName,
                newUser.displayName,
                newUser.status,
                newUser.email,
                newUser.password
        )
    }
}