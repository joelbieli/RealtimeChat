package chat

import com.fasterxml.jackson.annotation.JsonInclude
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class MDBChat(
        override val type: ChatType,
        override val title: String,
        val members: List<Id<String>>,
        val messages: List<Id<String>> = listOf(),
        val admin: Id<String>? = null,
        @BsonId val _id: Id<String> = newId()
): Chat {
    fun toFrontendChat(): FrontendChat {
        return FrontendChat(this.type, this.title, this.admin!!, this.members, this.messages, this._id)
    }
}