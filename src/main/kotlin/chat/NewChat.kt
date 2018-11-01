package chat

import utils.Base64Utils

class NewChat(
        override val title: String,
        type: String,
        val admin: String = "",
        val members: List<String>
): Chat {
    override val type: ChatType = ChatType.valueOf(type)

    fun toMDBChat(): MDBChat {
        return MDBChat(
                this.type,
                this.title,
                this.members.map { Base64Utils.decodeStringToId(it) },
                admin = if (!this.admin.isBlank()) Base64Utils.decodeStringToId(this.admin) else null
        )
    }
}