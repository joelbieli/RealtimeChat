[RealtimeChat](../../index.md) / [message](../index.md) / [MDBMessage](./index.md)

# MDBMessage

`class MDBMessage : `[`Message`](../-message/index.md)

The class which is read, write and update the messages collection of the database

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MDBMessage(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, timestamp: Instant, edited: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, author: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, _id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = newId())`<br>The class which is read, write and update the messages collection of the database |

### Properties

| Name | Summary |
|---|---|
| [_id](_id.md) | `val _id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>The id of the message |
| [chatId](chat-id.md) | `val chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>The id of the chat the message belongs to |
| [edited](edited.md) | `val edited: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If the message is edited |
| [text](text.md) | `val text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The content of the message |
| [timestamp](timestamp.md) | `val timestamp: Instant`<br>The timestamp converted to a java.time.Instant |

### Functions

| Name | Summary |
|---|---|
| [toFrontendMessage](to-frontend-message.md) | `fun toFrontendMessage(): `[`FrontendMessage`](../-frontend-message/index.md)<br>This method converts this MDBMessage to a FrontendMessage |
