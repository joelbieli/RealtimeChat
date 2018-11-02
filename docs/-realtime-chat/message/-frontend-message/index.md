[RealtimeChat](../../index.md) / [message](../index.md) / [FrontendMessage](./index.md)

# FrontendMessage

`class FrontendMessage : `[`Message`](../-message/index.md)

The class from which Jackson serializes the a requested message

### Parameters

`author` - The author of the chat

`chatId` - The id of the chat the message belongs to

`_id` - The if of the message

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FrontendMessage(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, timestamp: Instant, edited: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, author: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, chatId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, _id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>)`<br>The class from which Jackson serializes the a requested message |

### Properties

| Name | Summary |
|---|---|
| [edited](edited.md) | `val edited: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If the message is edited |
| [frontendId](frontend-id.md) | `val frontendId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The id of the message as a Bas64 encoded id |
| [text](text.md) | `val text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The content of the message |
| [timestamp](timestamp.md) | `val timestamp: Instant`<br>The timestamp as a java.time.Instant |

### Functions

| Name | Summary |
|---|---|
| [toMDBMessage](to-m-d-b-message.md) | `fun toMDBMessage(): `[`MDBMessage`](../-m-d-b-message/index.md)<br>This method converts the NewMessage to a MDBMessage |
