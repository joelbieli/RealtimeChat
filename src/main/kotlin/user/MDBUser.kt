package user

import com.fasterxml.jackson.annotation.JsonProperty
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import org.mindrot.jbcrypt.BCrypt

class MDBUser(
        override val displayName: String,
        override val status: String,
        val firstName: String,
        val lastName: String,
        val email: String,
        @BsonId val _id: Id<String> = newId(),
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val password: String = "",
        var hash: String = ""
): User {

    init {
        if (password.isNotBlank()) hash = BCrypt.hashpw(password, BCrypt.gensalt())
    }

    fun checkPW(rawPassword: String): Boolean {
        return BCrypt.checkpw(rawPassword, hash)
    }

    fun toFrontendUser(): FrontendUser {
        return FrontendUser(this.displayName, this.status, this._id)
    }

    fun toResponseUser(): ResponseUser {
        return ResponseUser(this.displayName, this.status, this.firstName, this.lastName, this.email, this._id)
    }
}