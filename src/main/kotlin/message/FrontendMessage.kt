package message

import org.litote.kmongo.Id
import utils.Base64Utils
import java.time.Instant

/**
 * The class from which Jackson serializes the a requested message
 *
 * @param author The author of the chat
 * @param chatId The id of the chat the message belongs to
 * @param _id The if of the message
 *
 * @property text The content of the message
 * @property timestamp The timestamp as a java.time.Instant
 * @property edited If the message is edited
 * @property author The author of the message as a Bas64 encoded id
 * @property chatId The id of the chat the message belongs to as a Bas64 encoded id
 * @property frontendId The id of the message as a Bas64 encoded id
 */
class FrontendMessage(
        override val text: String,
        override val timestamp: Instant,
        override val edited: Boolean,
        author: Id<String>,
        chatId: Id<String>,
        _id: Id<String>
): Message {
    private val author: String = Base64Utils.encodeIdToString(author)
    private val chatId: String = Base64Utils.encodeIdToString(chatId)
    val frontendId: String = Base64Utils.encodeIdToString(_id)

    /**
     * This method converts the NewMessage to a MDBMessage
     */
    fun toMDBMessage(): MDBMessage {
        return MDBMessage(
                this.text,
                this.timestamp,
                this.edited,
                Base64Utils.decodeStringToId(this.author),
                Base64Utils.decodeStringToId(this.chatId),
                Base64Utils.decodeStringToId(this.frontendId)
        )
    }
}