package message

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import java.time.Instant

/**
 * The class which is read, write and update the messages collection of the database
 *
 * @property text The content of the message
 * @property timestamp The timestamp converted to a java.time.Instant
 * @property edited If the message is edited
 * @property author The author of the message
 * @property chatId The id of the chat the message belongs to
 * @property _id The id of the message
 */
class MDBMessage(
        override val text: String,
        override val timestamp: Instant,
        override val edited: Boolean,
        private val author: Id<String>,
        val chatId: Id<String>,
        @BsonId val _id: Id<String> = newId()
): Message {
    /**
     * This method converts this MDBMessage to a FrontendMessage
     */
    fun toFrontendMessage(): FrontendMessage {
        return FrontendMessage(this.text, this.timestamp, this.edited, this.author, this.chatId, this._id)
    }
}