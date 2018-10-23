package user

import mdbcl
import org.litote.kmongo.eq
import org.litote.kmongo.findOne

fun newUser(user: User) {
    mdbcl.users.insertOne(user)
}

fun findUserByEmail(user: User): User? {
    return mdbcl.users.findOne(User::email eq user.email)
}