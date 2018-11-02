[RealtimeChat](../../index.md) / [chat](../index.md) / [MDBChat](./index.md)

# MDBChat

`class MDBChat : `[`Chat`](../-chat/index.md)

The class which is read, write and update the chats collection of the database

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MDBChat(type: `[`ChatType`](../-chat-type/index.md)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, members: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>, messages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>> = listOf(), admin: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null, _id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = newId())`<br>The class which is read, write and update the chats collection of the database |

### Properties

| Name | Summary |
|---|---|
| [_id](_id.md) | `val _id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>The id of the chat |
| [admin](admin.md) | `val admin: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`<br>The Base64 encoded id of the admin of the chat (is optional as a private chat doesn't have an admin) |
| [members](members.md) | `val members: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>`<br>The Base64 encoded ids of the chat members as a list |
| [messages](messages.md) | `val messages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>` |
| [title](title.md) | `val title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The title of the chat |
| [type](type.md) | `val type: `[`ChatType`](../-chat-type/index.md)<br>The type of chat |

### Functions

| Name | Summary |
|---|---|
| [toFrontendChat](to-frontend-chat.md) | `fun toFrontendChat(): `[`FrontendChat`](../-frontend-chat/index.md)<br>This method converts this MDBChat object to a FrontendChat |
