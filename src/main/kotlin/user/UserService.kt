package user

import mdbcl
import org.litote.kmongo.*

/**
 * Creates a new user in the database
 *
 * @param user The user to insert into the database
 */
fun newUser(user: MDBUser) {
    mdbcl.users.insertOne(user)
}

/**
 * Deletes a user in the database
 *
 * @param userId The id of the user to remove
 *
 * @return Whether the operation was successful
 */
fun deleteUser(userId: Id<String>): Boolean {
    return mdbcl.users.deleteOneById(id = userId).wasAcknowledged()
}

/**
 * Gets all users within a list of id
 *
 * @param users The list of ids
 *
 * @return The List of MDBUsers
 */
fun getUsers(users: List<Id<String>>): List<MDBUser> {
    return mdbcl.users.find(MDBUser::_id `in` users.asIterable()).toList()
}


/**
 * Adds the specified associate to the specified users associations
 *
 * @param userId The user to which to add the association
 * @param associateId The associate to add to the associations
 *
 * @return Whether the operation was successful
 */
fun addAssociation(userId: Id<String>, associateId: Id<String>): Boolean {
    return mdbcl.users.updateOneById(userId, push(MDBUser::associations, associateId)).wasAcknowledged()
}

/**
 * Removes the specified associate from the specified users associations
 *
 * @param userId The user from which to remove the association
 * @param associateId The associate to remove to the associations
 *
 * @return Whether the operation was successful
 */
fun removeAssociation(userId: Id<String>, associateId: Id<String>): Boolean {
    return mdbcl.users.updateOneById(userId, pull(MDBUser::associations, associateId)).wasAcknowledged()
}

/**
 * Gets the user with the specified email
 *
 * @param email The email for which to get the user for
 *
 * @return The user with the email
 */
fun findUserByEmail(email: String): MDBUser? {
    return mdbcl.users.findOne(MDBUser::email eq email)
}

/**
 * Gets the user with the specified id
 *
 * @param id The id for which to get the user for
 *
 * @return The user with the id
 */
fun findUserById(id: Id<String>): MDBUser? {
    return mdbcl.users.findOneById(id)
}

/**
 * Updates the display name of the specified user
 *
 * @param userId The id of the user of which to change the display name
 * @param newDisplayName The new display name
 *
 * @return Whether the operation was successful
 */
fun updateDisplayName(userId: Id<String>, newDisplayName: String): Boolean {
    return mdbcl.users.updateOneById(userId, set(MDBUser::displayName, newDisplayName)).wasAcknowledged()
}

/**
 * Updates the status of the specified user
 *
 * @param userId The id of the user of which to change the status
 * @param newStatus The new status
 *
 * @return Whether the operation was successful
 */
fun updateStatus(userId: Id<String>, newStatus: String): Boolean {
    return mdbcl.users.updateOneById(userId, set(MDBUser::status, newStatus)).wasAcknowledged()
}