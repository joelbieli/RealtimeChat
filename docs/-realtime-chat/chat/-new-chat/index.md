[RealtimeChat](../../index.md) / [chat](../index.md) / [NewChat](./index.md)

# NewChat

`class NewChat : `[`Chat`](../-chat/index.md)

The class to which Jackson deserializes the new chat request body

### Parameters

`type` - The chat type as a string representation

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NewChat(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, admin: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", members: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>)`<br>The class to which Jackson deserializes the new chat request body |

### Properties

| Name | Summary |
|---|---|
| [title](title.md) | `val title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The title of the chat |
| [type](type.md) | `val type: `[`ChatType`](../-chat-type/index.md)<br>The type string as an actual ChatType |

### Functions

| Name | Summary |
|---|---|
| [toMDBChat](to-m-d-b-chat.md) | `fun toMDBChat(): `[`MDBChat`](../-m-d-b-chat/index.md)<br>This method converts this NewChat object to a MDBChat |
