package chat

import mdbcl
import org.litote.kmongo.*

fun newChat(chat: Chat) {
    mdbcl.chats.insertOne(chat)
}

fun deleteChat(chatId: Id<String>): Boolean {
    return mdbcl.chats.deleteOneById(chatId).wasAcknowledged()
}

fun addMember(chatId: Id<String>, userId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, push(Chat::members, userId)).wasAcknowledged()
}

fun removeMember(chatId: Id<String>, userId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, pull(Chat::members, userId)).wasAcknowledged()
}

fun addMessage(chatId: Id<String>, messageId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, push(Chat::messages, messageId)).wasAcknowledged()
}

fun removeMessage(chatId: Id<String>, messageId: Id<String>): Boolean {
    return mdbcl.chats.updateOneById(chatId, pull(Chat::messages, messageId)).wasAcknowledged()
}

fun updateTitle(chatId: Id<String>, newTitle: String): Boolean {
    return mdbcl.chats.updateOneById(chatId, set(Chat::title, newTitle)).wasAcknowledged()
}