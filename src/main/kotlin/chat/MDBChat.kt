package chat

import com.fasterxml.jackson.annotation.JsonInclude
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId

/**
 * The class which is read, write and update the chats collection of the database
 *
 * @property type The type of chat
 * @property title The title of the chat
 * @property admin The Base64 encoded id of the admin of the chat (is optional as a private chat doesn't have an admin)
 * @property members The Base64 encoded ids of the chat members as a list
 * @property _id The id of the chat
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class MDBChat(
        override val type: ChatType,
        override val title: String,
        val members: List<Id<String>>,
        val messages: List<Id<String>> = listOf(),
        val admin: Id<String>? = null,
        @BsonId val _id: Id<String> = newId()
): Chat {
    /**
     * This method converts this MDBChat object to a FrontendChat
     */
    fun toFrontendChat(): FrontendChat {
        return FrontendChat(this.type, this.title, this.admin!!, this.members, this.messages, this._id)
    }
}