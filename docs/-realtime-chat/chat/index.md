[RealtimeChat](../index.md) / [chat](./index.md)

## Package chat

### Types

| Name | Summary |
|---|---|
| [Chat](-chat/index.md) | `interface Chat`<br>The chat interface which all sub-types must implement |
| [ChatHandler](-chat-handler/index.md) | `object ChatHandler`<br>This singleton object holds all logic to handle chat related requests |
| [ChatType](-chat-type/index.md) | `enum class ChatType`<br>The enum describing all possible types of chats |
| [FrontendChat](-frontend-chat/index.md) | `class FrontendChat : `[`Chat`](-chat/index.md)<br>The class from which Jackson serializes the a requested chat |
| [MDBChat](-m-d-b-chat/index.md) | `class MDBChat : `[`Chat`](-chat/index.md)<br>The class which is read, write and update the chats collection of the database |
| [NewChat](-new-chat/index.md) | `class NewChat : `[`Chat`](-chat/index.md)<br>The class to which Jackson deserializes the new chat request body |

### Functions

| Name | Summary |
|---|---|
| [addMember](add-member.md) | `fun addMember(chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, userId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Adds a member to the specified chat |
| [addMessage](add-message.md) | `fun addMessage(chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, messageId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Adds a member to the specified chat |
| [deleteChat](delete-chat.md) | `fun deleteChat(chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deletes a chat in the database |
| [newChat](new-chat.md) | `fun newChat(chat: `[`MDBChat`](-m-d-b-chat/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Creates a new chat in the database |
| [removeMember](remove-member.md) | `fun removeMember(chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, userId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Removes a member from the specified chat |
| [removeMessage](remove-message.md) | `fun removeMessage(chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, messageId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Removes a member from the specified chat |
| [updateTitle](update-title.md) | `fun updateTitle(chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, newTitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Updates the title of a specified chat |
