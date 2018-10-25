package user

import mdbcl
import org.litote.kmongo.*
import org.litote.kmongo.id.WrappedObjectId
import utils.merge

fun newUser(user: User) {
    mdbcl.users.insertOne(user)
}

fun findUserByEmail(email: String): User? {
    return mdbcl.users.findOne(User::email eq email)
}

fun findUserById(id: String): User? {
    return mdbcl.users.findOneById(WrappedObjectId<String>(id))
}

fun updateUser(alteredUser: User, oldUser: User): User? {
    mdbcl.users.updateOneById(oldUser._id!!, oldUser merge alteredUser)
    return mdbcl.users.findOneById(oldUser._id)
}