package user

import com.mongodb.client.model.UpdateOptions
import mdbcl
import org.litote.kmongo.*
import org.litote.kmongo.id.WrappedObjectId

fun newUser(user: MDBUser) {
    mdbcl.users.insertOne(user)
}

fun deleteUser(userId: Id<String>): Boolean {
    return mdbcl.users.deleteOneById(id = userId).wasAcknowledged()
}

fun getUsers(members: List<Id<String>>): List<MDBUser> {
    return mdbcl.users.find(MDBUser::_id `in` members.asIterable()).toList()
}

fun findUserByEmail(email: String): MDBUser? {
    return mdbcl.users.findOne(MDBUser::email eq email)
}

fun findUserById(id: Id<String>): MDBUser? {
    return mdbcl.users.findOneById(id)
}

fun updateDisplayName(userId: Id<String>, newDisplayName: String): Boolean {
    return mdbcl.users.updateOneById(userId, set(MDBUser::displayName, newDisplayName)).wasAcknowledged()
}

fun updateStatus(userId: Id<String>, newStatus: String): Boolean {
    return mdbcl.users.updateOneById(userId, set(MDBUser::status, newStatus)).wasAcknowledged()
}