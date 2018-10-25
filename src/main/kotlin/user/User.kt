package user

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import org.mindrot.jbcrypt.BCrypt
import utils.sign

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class User (
        var displayName: String = "",
        var status: String = "",
        var firstName: String = "",
        var lastName: String = "",
        var email: String = "",
        @BsonId
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val _id: Id<String>? = null,
        var jwt: String = if (_id != null) sign(_id) else "",
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        var password: String = ""
        ) {
    var hash: String = if (!password.isBlank()) BCrypt.hashpw(password, BCrypt.gensalt()) else ""

    fun checkPW(pw: String): Boolean {
        return BCrypt.checkpw(pw, hash)
    }

    fun toFrontendUser(): User {
        return User(this.displayName, this.status, _id = newId())
    }

    fun toResponseUser(): User {
        return User(this.displayName, this.status, this.firstName, this.lastName, this.email, _id = this._id)
    }
}