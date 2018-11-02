package chat

import utils.Base64Utils

/**
 * The class to which Jackson deserializes the new chat request body
 *
 * @param type The chat type as a string representation
 *
 * @property title The title of the chat
 * @property admin The Base64 encoded id of the admin of the chat (is optional as a private chat doesn't have an admin)
 * @property members The Base64 encoded ids of the chat members as a list
 * @property type The type string as an actual ChatType
 */
class NewChat(
        override val title: String,
        type: String,
        private val admin: String = "",
        private val members: List<String>
): Chat {
    override val type: ChatType = ChatType.valueOf(type)

    /**
     * This method converts this NewChat object to a MDBChat
     */
    fun toMDBChat(): MDBChat {
        return MDBChat(
                this.type,
                this.title,
                this.members.map { Base64Utils.decodeStringToId(it) }, // converts the list of strings to a list of Id<String>
                admin = if (!this.admin.isBlank()) Base64Utils.decodeStringToId(this.admin) else null
        )
    }
}