[RealtimeChat](../../index.md) / [user](../index.md) / [User](./index.md)

# User

`interface User`

The User interface all sub-type have to implement

### Properties

| Name | Summary |
|---|---|
| [displayName](display-name.md) | `abstract val displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [status](status.md) | `abstract val status: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [FrontendUser](../-frontend-user/index.md) | `class FrontendUser : `[`User`](./index.md)<br>The class which is read, write and update the users collection of the database |
| [MDBUser](../-m-d-b-user/index.md) | `class MDBUser : `[`User`](./index.md)<br>The class which is read, write and update the users collection of the database |
| [ResponseUser](../-response-user/index.md) | `class ResponseUser : `[`User`](./index.md)<br>The class which is read, write and update the users collection of the database |
