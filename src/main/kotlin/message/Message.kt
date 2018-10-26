package message

import chat.Chat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.codec.binary.Base64
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import java.time.Instant

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class Message (
        var text: String,
        var author: Id<String>,
        timestamp: Long,
        var edited: Boolean = false,
        @BsonId
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val _id: Id<String> = newId(),
        val frontendId: String = ""
) {
    val timestamp = Instant.ofEpochMilli(timestamp)

    fun toFrontendMessage(): Message {
        return Message(
                this.text,
                this.author,
                timestamp.toEpochMilli(),
                this.edited,
                frontendId = Base64().encodeToString(this._id.toString().toByteArray())
        )
    }
}