package user

import com.fasterxml.jackson.annotation.JsonProperty
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import org.mindrot.jbcrypt.BCrypt

/**
 * The class which is read, write and update the users collection of the database
 *
 * @property displayName The display name, visible to other users
 * @property status The status message
 * @property firstName The first name of the user
 * @property lastName The last name of the user
 * @property email The email address of the user
 * @property _id The id of the user
 * @property password The password of the user (only used when the user is first created, not actually stored)
 * @property hash The hashed password
 */
class MDBUser(
        override val displayName: String,
        override val status: String,
        private val firstName: String,
        private val lastName: String,
        val email: String,
        @BsonId val _id: Id<String> = newId(),
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val password: String = "",
        private var hash: String = ""
): User {

    init {
        // Sets the hash to the hashed password if a password is provided
        if (password.isNotBlank()) hash = BCrypt.hashpw(password, BCrypt.gensalt())
    }

    /**
     * Checks if the provided password matches the one that the hash originated from
     *
     * @param rawPassword The password to check
     *
     * @return if the password matches
     */
    fun checkPW(rawPassword: String): Boolean {
        return BCrypt.checkpw(rawPassword, hash)
    }

    /**
     * This method converts this MDBUser object to a FrontendUser
     */
    fun toFrontendUser(): FrontendUser {
        return FrontendUser(this.displayName, this.status, this._id)
    }

    /**
     * This method converts this MDBUser object to a ResponseUser
     */
    fun toResponseUser(): ResponseUser {
        return ResponseUser(this.displayName, this.status, this.firstName, this.lastName, this.email, this._id)
    }
}