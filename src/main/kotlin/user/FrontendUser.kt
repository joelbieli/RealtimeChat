package user

import org.apache.commons.codec.binary.Base64
import org.litote.kmongo.Id
import utils.Base64Utils

class FrontendUser(
        override val displayName: String,
        override val status: String,
        _id: Id<String>
): User {
    val frontendId: String = Base64Utils.encodeIdToString(_id)
}