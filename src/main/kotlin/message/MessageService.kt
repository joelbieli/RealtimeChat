package message

import mdbcl
import org.litote.kmongo.*

/**
 * Creates a new message in the database
 *
 * @param message The message to insert into the database
 */
fun newMessage(message: MDBMessage) {
    mdbcl.messages.insertOne(message)
}

/**
 * Deletes a message in the database
 *
 * @param messageId The id of the message to remove
 *
 * @return Whether the operation was successful
 */
fun deleteMessage(messageId: Id<String>): Boolean {
    return mdbcl.messages.deleteOneById(messageId).wasAcknowledged()
}

/**
 * Updates the content of a specified message
 *
 * @param messageId The id of the message of which to change the text
 * @param newMessage The new content of the message
 *
 * @return Whether the operation was successful
 */
fun updateMessage(messageId: Id<String>, newMessage: String): Boolean {
    return mdbcl.messages.updateOneById(messageId, set(MDBMessage::text, newMessage)).wasAcknowledged()
}

/**
 * Gets all messages within a list of id as a list of FrontendMessage
 *
 * @param messages The list of ids
 *
 * @return The List of FrontendMessages
 */
fun getFrontendMessages(messages: List<Id<String>>): List<FrontendMessage> {
    return mdbcl.messages.find(MDBMessage::_id `in` messages.asIterable()).toList().map { it.toFrontendMessage() }
}