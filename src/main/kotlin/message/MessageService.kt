package message

import mdbcl
import org.litote.kmongo.Id
import org.litote.kmongo.`in`
import org.litote.kmongo.toList

fun getMessages(messages: List<Id<String>>): List<Message> {
    return mdbcl.messages.find(Message::_id `in` messages.asIterable()).toList()
}