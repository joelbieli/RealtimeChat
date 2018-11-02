[RealtimeChat](../../index.md) / [message](../index.md) / [Message](./index.md)

# Message

`interface Message`

The Message interface all sub-types have to implement

### Properties

| Name | Summary |
|---|---|
| [edited](edited.md) | `abstract val edited: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [text](text.md) | `abstract val text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [timestamp](timestamp.md) | `abstract val timestamp: Instant` |

### Inheritors

| Name | Summary |
|---|---|
| [FrontendMessage](../-frontend-message/index.md) | `class FrontendMessage : `[`Message`](./index.md)<br>The class from which Jackson serializes the a requested message |
| [MDBMessage](../-m-d-b-message/index.md) | `class MDBMessage : `[`Message`](./index.md)<br>The class which is read, write and update the messages collection of the database |
| [NewMessage](../-new-message/index.md) | `class NewMessage : `[`Message`](./index.md)<br>The class to which Jackson deserializes the new message request body |
