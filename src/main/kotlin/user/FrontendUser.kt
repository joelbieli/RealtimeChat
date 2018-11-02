package user

import org.litote.kmongo.Id
import utils.Base64Utils

/**
 * The class which is read, write and update the users collection of the database
 *
 * @param _id The id of the user
 *
 * @property displayName The display name, visible to other users
 * @property status The status message
 * @property frontendId The id of the user as a Base64 encoded string
 */
class FrontendUser(
        override val displayName: String,
        override val status: String,
        _id: Id<String>
): User {
    private val frontendId: String = Base64Utils.encodeIdToString(_id)
}