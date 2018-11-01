package user

import org.litote.kmongo.Id
import utils.sign

class ResponseUser(
        override val displayName: String,
        override val status: String,
        val firstName: String,
        val lastName: String,
        val email: String,
        _id: Id<String>
): User {
    val jwt: String = sign(_id)
}