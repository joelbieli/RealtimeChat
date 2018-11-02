[RealtimeChat](../../index.md) / [chat](../index.md) / [Chat](./index.md)

# Chat

`interface Chat`

The chat interface which all sub-types must implement

### Properties

| Name | Summary |
|---|---|
| [title](title.md) | `abstract val title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | `abstract val type: `[`ChatType`](../-chat-type/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [FrontendChat](../-frontend-chat/index.md) | `class FrontendChat : `[`Chat`](./index.md)<br>The class from which Jackson serializes the a requested chat |
| [MDBChat](../-m-d-b-chat/index.md) | `class MDBChat : `[`Chat`](./index.md)<br>The class which is read, write and update the chats collection of the database |
| [NewChat](../-new-chat/index.md) | `class NewChat : `[`Chat`](./index.md)<br>The class to which Jackson deserializes the new chat request body |
