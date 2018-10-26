package user

import mdbcl
import message.Message
import org.litote.kmongo.*
import org.litote.kmongo.id.WrappedObjectId
import utils.merge

fun newUser(user: User) {
    mdbcl.users.insertOne(user)
}

fun deleteUser(userId: Id<String>): Boolean {
    return mdbcl.users.deleteOneById(userId).wasAcknowledged()
}

fun getMembers(members: List<Id<String>>): List<User> {
    return mdbcl.users.find(User::_id `in` members.asIterable()).toList()
}

fun findUserByEmail(email: String): User? {
    return mdbcl.users.findOne(User::email eq email)
}

fun findUserById(id: String): User? {
    return mdbcl.users.findOneById(WrappedObjectId<String>(id))
}

fun updateUser(alteredUser: User, oldUser: User): User? {
    val updateSuccessful = mdbcl.users.updateOneById(oldUser._id!!, oldUser merge alteredUser).wasAcknowledged()
    return if (updateSuccessful) {
        mdbcl.users.findOneById(oldUser._id)
    } else {
        null
    }
}