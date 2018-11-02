[RealtimeChat](../../index.md) / [message](../index.md) / [NewMessage](./index.md)

# NewMessage

`class NewMessage : `[`Message`](../-message/index.md)

The class to which Jackson deserializes the new message request body

### Parameters

`timestamp` - The UNIX timestamp representing when the message was created

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NewMessage(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, timestamp: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, edited: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, author: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, chatId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>The class to which Jackson deserializes the new message request body |

### Properties

| Name | Summary |
|---|---|
| [edited](edited.md) | `val edited: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If the message is edited |
| [text](text.md) | `val text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The content of the message |
| [timestamp](timestamp.md) | `val timestamp: Instant`<br>The timestamp converted to a java.time.Instant |

### Functions

| Name | Summary |
|---|---|
| [toMDBMessage](to-m-d-b-message.md) | `fun toMDBMessage(): `[`MDBMessage`](../-m-d-b-message/index.md)<br>This method converts the NewMessage to a MDBMessage |
