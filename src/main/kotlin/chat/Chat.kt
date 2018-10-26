package chat

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import message.getMessages
import org.apache.commons.codec.binary.Base64
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import user.getMembers

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class Chat (
        val type: ChatType,
        val title: String = "",
        members: List<Id<String>>? = null,
        messages: List<Id<String>>? = null,
        val admin: Id<String>? = null,
        @BsonId
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val _id: Id<String> = newId(),
        val frontendId: String = ""
) {
    val members = if (members != null) getMembers(members) else null
    val messages = if (messages != null) getMessages(messages) else null

    fun toFrontendChat(): Chat {
        return Chat(
                this.type,
                this.title,
                members?.map{ it._id },
                messages?.map{ it._id },
                this.admin,
                frontendId = Base64().encodeToString(this._id.toString().toByteArray())
        )
    }
}