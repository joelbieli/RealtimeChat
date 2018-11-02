[RealtimeChat](../index.md) / [message](./index.md)

## Package message

### Types

| Name | Summary |
|---|---|
| [FrontendMessage](-frontend-message/index.md) | `class FrontendMessage : `[`Message`](-message/index.md)<br>The class from which Jackson serializes the a requested message |
| [MDBMessage](-m-d-b-message/index.md) | `class MDBMessage : `[`Message`](-message/index.md)<br>The class which is read, write and update the messages collection of the database |
| [Message](-message/index.md) | `interface Message`<br>The Message interface all sub-types have to implement |
| [MessageHandler](-message-handler/index.md) | `object MessageHandler`<br>This singleton object holds all logic to handle message related requests |
| [NewMessage](-new-message/index.md) | `class NewMessage : `[`Message`](-message/index.md)<br>The class to which Jackson deserializes the new message request body |

### Functions

| Name | Summary |
|---|---|
| [deleteMessage](delete-message.md) | `fun deleteMessage(messageId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deletes a message in the database |
| [getFrontendMessages](get-frontend-messages.md) | `fun getFrontendMessages(messages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FrontendMessage`](-frontend-message/index.md)`>`<br>Gets all messages within a list of id as a list of FrontendMessage |
| [newMessage](new-message.md) | `fun newMessage(message: `[`MDBMessage`](-m-d-b-message/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Creates a new message in the database |
| [updateMessage](update-message.md) | `fun updateMessage(messageId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, newMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Updates the content of a specified message |
