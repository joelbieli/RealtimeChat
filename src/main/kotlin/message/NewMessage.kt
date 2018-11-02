package message

import utils.Base64Utils
import java.time.Instant

/**
 * The class to which Jackson deserializes the new message request body
 *
 * @param timestamp The UNIX timestamp representing when the message was created
 *
 * @property text The content of the message
 * @property edited If the message is edited
 * @property author The author of the message as a Bas64 encoded id
 * @property chatId The id of the chat the message belongs to as a Bas64 encoded id
 * @property timestamp The timestamp converted to a java.time.Instant
 */
class NewMessage (
        override val text: String,
        timestamp: Long,
        override val edited: Boolean,
        private val author: String,
        private val chatId: String
): Message {
    override val timestamp: Instant = Instant.ofEpochMilli(timestamp)

    /**
     * This method converts the NewMessage to a MDBMessage
     */
    fun toMDBMessage(): MDBMessage {
        return MDBMessage(
                this.text,
                this.timestamp,
                this.edited,
                Base64Utils.decodeStringToId(this.author),
                Base64Utils.decodeStringToId(this.chatId))
    }
}