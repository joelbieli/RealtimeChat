package user

import org.litote.kmongo.Id
import utils.JWTUtils

/**
 * The class which is read, write and update the users collection of the database
 *
 * @param _id The id of the user
 *
 * @property displayName The display name, visible to other users
 * @property status The status message
 * @property firstName The first name of the user
 * @property lastName The last name of the user
 * @property email The email address of the user
 * @property associations Every users id the user is in some way associated with as a Base64 encoded id
 * @property jwt The JWT of the user
 */
class ResponseUser(
        override val displayName: String,
        override val status: String,
        private val firstName: String,
        private val lastName: String,
        private val email: String,
        private val associations: List<String>,
        _id: Id<String>
): User {
    private val jwt: String = JWTUtils.sign(_id)
}