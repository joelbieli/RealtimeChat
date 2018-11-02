package chat

import mdbcl
import org.litote.kmongo.*

/**
 * Creates a new chat in the database
 *
 * @param chat The chat to insert into the database
 */
fun newChat(chat: MDBChat) {
    mdbcl.chats.insertOne(chat)
}

/**
 * Deletes a chat in the database
 *
 * @param chatId The id of the chat to remove
 *
 * @return Whether the operation was successful
 */
fun deleteChat(chatId: Id<String>): Boolean {
    return mdbcl.chats.deleteOneById(chatId).wasAcknowledged()
}

/**
 * Adds a member to the specified chat
 *
 * @param chatId The id of the chat to which the user is added
 * @param userId The id of the user to add
 *
 * @return Whether the operation was successful
 */
fun addMember(chatId: Id<String>, userId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, push(MDBChat::members, userId)).wasAcknowledged()
}

/**
 * Removes a member from the specified chat
 *
 * @param chatId The id of the chat from which to remove the user
 * @param userId The id of the user to remove
 *
 * @return Whether the operation was successful
 */
fun removeMember(chatId: Id<String>, userId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, pull(MDBChat::members, userId)).wasAcknowledged()
}

/**
 * Adds a member to the specified chat
 *
 * @param chatId The id of the chat to which the message is added
 * @param messageId The id of the message to add
 *
 * @return Whether the operation was successful
 */
fun addMessage(chatId: Id<String>, messageId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, push(MDBChat::messages, messageId)).wasAcknowledged()
}

/**
 * Removes a member from the specified chat
 *
 * @param chatId The id of the chat from which to remove the message
 * @param messageId The id of the message to remove
 *
 * @return Whether the operation was successful
 */
fun removeMessage(chatId: Id<String>, messageId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, pull(MDBChat::messages, messageId)).wasAcknowledged()
}

/**
 * Updates the title of a specified chat
 *
 * @param chatId The id of the chat of which to change the title
 * @param newTitle The new title
 *
 * @return Whether the operation was successful
 */
fun updateTitle(chatId: Id<String>, newTitle: String): Boolean {
    return mdbcl.chats.updateOneById(chatId, set(MDBChat::title, newTitle)).wasAcknowledged()
}