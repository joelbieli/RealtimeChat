[RealtimeChat](../../index.md) / [chat](../index.md) / [FrontendChat](./index.md)

# FrontendChat

`class FrontendChat : `[`Chat`](../-chat/index.md)

The class from which Jackson serializes the a requested chat

### Parameters

`admin` - The admin of the chat

`members` - The members of the chat as a list of Id

`messages` - The members of the chat as a list of Id

`_id` - The id of the chat

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FrontendChat(type: `[`ChatType`](../-chat-type/index.md)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, admin: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, members: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>, messages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>, _id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>)`<br>The class from which Jackson serializes the a requested chat |

### Properties

| Name | Summary |
|---|---|
| [title](title.md) | `val title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The title of the chat |
| [type](type.md) | `val type: `[`ChatType`](../-chat-type/index.md)<br>The chat type |

### Functions

| Name | Summary |
|---|---|
| [toMDBChat](to-m-d-b-chat.md) | `fun toMDBChat(): `[`MDBChat`](../-m-d-b-chat/index.md)<br>This method converts this FrontendChat object to a MDBChat |
