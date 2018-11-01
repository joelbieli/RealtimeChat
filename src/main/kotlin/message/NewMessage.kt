package message

import utils.Base64Utils
import java.time.Instant

class NewMessage (
        override val text: String,
        timestamp: Long,
        override val edited: Boolean,
        val author: String,
        val chatId: String
): Message {
    override val timestamp: Instant = Instant.ofEpochMilli(timestamp)

    fun toMDBMessage(): MDBMessage {
        return MDBMessage(
                this.text,
                this.timestamp,
                this.edited,
                Base64Utils.decodeStringToId(this.author),
                Base64Utils.decodeStringToId(this.chatId))
    }
}