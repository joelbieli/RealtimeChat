package user

import mdbcl
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.updateOne
import utils.merge

fun newUser(user: User) {
    mdbcl.users.insertOne(user)
}

fun findUserByEmail(user: User): User? {
    return mdbcl.users.findOne(User::email eq user.email)
}

fun updateUser(user: User) {
    val oldUser = mdbcl.users.findOne(User::email eq user.email)
    mdbcl.users.updateOne(User::email eq user.email, oldUser?.merge(user)!!)
}