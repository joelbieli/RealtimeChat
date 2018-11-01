package chat

import message.FrontendMessage
import message.getFrontendMessages
import org.litote.kmongo.Id
import utils.Base64Utils

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