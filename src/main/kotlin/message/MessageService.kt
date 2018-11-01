package message

import mdbcl
import org.litote.kmongo.*

fun newMessage(message: MDBMessage) {
    mdbcl.messages.insertOne(message)
}

fun deleteMessage(messageId: Id<String>): Boolean {
    return mdbcl.messages.deleteOneById(messageId).wasAcknowledged()
}

fun updateMessage(messageId: Id<String>, newMessage: String): Boolean {
    return mdbcl.messages.updateOneById(messageId, set(MDBMessage::text, newMessage)).wasAcknowledged()
}

fun getFrontendMessages(messages: List<Id<String>>): List<FrontendMessage> {
    return mdbcl.messages.find(MDBMessage::_id `in` messages.asIterable()).toList().map { it.toFrontendMessage() }
}