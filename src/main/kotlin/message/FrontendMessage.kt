package message

import org.litote.kmongo.Id
import utils.Base64Utils
import java.time.Instant

class FrontendMessage(
        override val text: String,
        override val timestamp: Instant,
        override val edited: Boolean,
        author: Id<String>,
        chatId: Id<String>,
        frontendId: Id<String>
): Message {
    val author: String = Base64Utils.encodeIdToString(author)
    val chatId: String = Base64Utils.encodeIdToString(chatId)
    val frontendId: String = Base64Utils.encodeIdToString(frontendId)

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