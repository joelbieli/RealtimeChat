[RealtimeChat](../../index.md) / [user](../index.md) / [MDBUser](./index.md)

# MDBUser

`class MDBUser : `[`User`](../-user/index.md)

The class which is read, write and update the users collection of the database

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MDBUser(displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, status: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, firstName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lastName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, associations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>> = listOf(), _id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = newId(), password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", hash: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "")`<br>The class which is read, write and update the users collection of the database |

### Properties

| Name | Summary |
|---|---|
| [_id](_id.md) | `val _id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>The id of the user |
| [associations](associations.md) | `val associations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>`<br>Every users id the user is in some way associated with |
| [displayName](display-name.md) | `val displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The display name, visible to other users |
| [email](email.md) | `val email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The email address of the user |
| [password](password.md) | `val password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The password of the user (only used when the user is first created, not actually stored) |
| [status](status.md) | `val status: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The status message |

### Functions

| Name | Summary |
|---|---|
| [checkPW](check-p-w.md) | `fun checkPW(rawPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if the provided password matches the one that the hash originated from |
| [toFrontendUser](to-frontend-user.md) | `fun toFrontendUser(): `[`FrontendUser`](../-frontend-user/index.md)<br>This method converts this MDBUser object to a FrontendUser |
| [toResponseUser](to-response-user.md) | `fun toResponseUser(): `[`ResponseUser`](../-response-user/index.md)<br>This method converts this MDBUser object to a ResponseUser |
