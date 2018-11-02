package chat

import message.FrontendMessage
import message.getFrontendMessages
import org.litote.kmongo.Id
import utils.Base64Utils

/**
 * The class from which Jackson serializes the a requested chat
 *
 * @param admin The admin of the chat
 * @param members The members of the chat as a list of Id<String>
 * @param messages The members of the chat as a list of Id<String>
 * @param _id The id of the chat
 *
 * @property title The title of the chat
 * @property type The chat type
 * @property admin The Base64 encoded id of the admin of the chat (is optional as a private chat doesn't have an admin)
 * @property members The members as a list of Base64 encoded ids
 * @property messages The messages of the chat as a list of FrontendMessage
 * @property frontendId The _id as a Base64 encoded string
 */
class FrontendChat(
        override val type: ChatType,
        override val title: String,
        admin: Id<String>,
        members: List<Id<String>>,
        messages: List<Id<String>>,
        _id: Id<String>
): Chat {
    val admin: String = Base64Utils.encodeIdToString(admin)
    val members: List<String> = members.map { Base64Utils.encodeIdToString(it) }
    val messages: List<FrontendMessage> = getFrontendMessages(messages)
    val frontendId: String = Base64Utils.encodeIdToString(_id)

    /**
     * This method converts this FrontendChat object to a MDBChat
     */
    fun toMDBChat(): MDBChat {
        return MDBChat(
                this.type,
                this.title,
                this.members.map { Base64Utils.decodeStringToId(it) },
                this.messages.map { Base64Utils.decodeStringToId(it.frontendId) },
                Base64Utils.decodeStringToId(this.admin),
                Base64Utils.decodeStringToId(this.frontendId)
        )
    }
}