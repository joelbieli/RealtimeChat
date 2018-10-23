package user

import com.fasterxml.jackson.annotation.JsonInclude
import org.mindrot.jbcrypt.BCrypt
import utils.sign

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class User (
        var displayName: String = "",
        var status: String = "",
        var firstName: String = "",
        var lastName: String = "",
        var email: String = "",
        var jwt: String = if (email.isBlank()) "" else sign(email),
        var password: String = ""
        ) {
    var hash: String = BCrypt.hashpw(password, BCrypt.gensalt())

    fun checkPW(pw: String): Boolean {
        return BCrypt.checkpw(pw, hash)
    }

    fun toFrontendUser(): User {
        return User(this.displayName, this.status)
    }

    fun toResponseUser(): User {
        return User(this.displayName, this.status, this.firstName, this.lastName, this.email)
    }
}