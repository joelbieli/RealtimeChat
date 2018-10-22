package user

import mdbcl

fun newUser(user: User) {
    mdbcl.users.insertOne(user)
}