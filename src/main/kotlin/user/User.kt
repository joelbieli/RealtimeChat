package user

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.codec.binary.Base64
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import org.mindrot.jbcrypt.BCrypt
import utils.sign

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class User (
        val displayName: String = "",
        val status: String = "",
        val firstName: String = "",
        val lastName: String = "",
        val email: String = "",
        @BsonId
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val _id: Id<String> = newId(),
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val password: String = "",
        val jwt: String = "",
        val frontendId: String = ""
) {
    var hash: String = if (!password.isBlank()) BCrypt.hashpw(password, BCrypt.gensalt()) else ""

    fun checkPW(pw: String): Boolean {
        return BCrypt.checkpw(pw, hash)
    }

    fun toFrontendUser(): User {
        return User(this.displayName, this.status, frontendId = Base64().encodeToString(this._id.toString().toByteArray()))
    }

    fun toResponseUser(): User {
        return User(this.displayName, this.status, this.firstName, this.lastName, this.email, jwt = sign(_id))
    }
}