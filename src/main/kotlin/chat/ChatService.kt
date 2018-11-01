package chat

import mdbcl
import org.litote.kmongo.*

fun newChat(chat: MDBChat) {
    mdbcl.chats.insertOne(chat)
}

fun deleteChat(chatId: Id<String>): Boolean {
    return mdbcl.chats.deleteOneById(chatId).wasAcknowledged()
}

fun addMember(chatId: Id<String>, userId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, push(MDBChat::members, userId)).wasAcknowledged()
}

fun removeMember(chatId: Id<String>, userId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, pull(MDBChat::members, userId)).wasAcknowledged()
}

fun addMessage(chatId: Id<String>, messageId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, push(MDBChat::messages, messageId)).wasAcknowledged()
}

fun removeMessage(chatId: Id<String>, messageId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, pull(MDBChat::messages, messageId)).wasAcknowledged()
}

fun updateTitle(chatId: Id<String>, newTitle: String): Boolean {
    return mdbcl.chats.updateOneById(chatId, set(MDBChat::title, newTitle)).wasAcknowledged()
}