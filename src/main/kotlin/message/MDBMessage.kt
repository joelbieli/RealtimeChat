package message

import com.fasterxml.jackson.annotation.JsonProperty
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import java.time.Instant

class MDBMessage(
        override val text: String,
        override val timestamp: Instant,
        override val edited: Boolean,
        val author: Id<String>,
        val chatId: Id<String>,
        @BsonId val _id: Id<String> = newId()
): Message {
    fun toFrontendMessage(): FrontendMessage {
        return FrontendMessage(this.text, this.timestamp, this.edited, this.author, this.chatId, this._id)
    }
}