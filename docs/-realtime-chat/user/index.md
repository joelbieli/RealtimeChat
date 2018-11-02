[RealtimeChat](../index.md) / [user](./index.md)

## Package user

### Types

| Name | Summary |
|---|---|
| [FrontendUser](-frontend-user/index.md) | `class FrontendUser : `[`User`](-user/index.md)<br>The class which is read, write and update the users collection of the database |
| [MDBUser](-m-d-b-user/index.md) | `class MDBUser : `[`User`](-user/index.md)<br>The class which is read, write and update the users collection of the database |
| [ResponseUser](-response-user/index.md) | `class ResponseUser : `[`User`](-user/index.md)<br>The class which is read, write and update the users collection of the database |
| [User](-user/index.md) | `interface User`<br>The User interface all sub-type have to implement |
| [UserHandler](-user-handler/index.md) | `object UserHandler` |

### Functions

| Name | Summary |
|---|---|
| [addAssociation](add-association.md) | `fun addAssociation(userId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, associateId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Adds the specified associate to the specified users associations |
| [deleteUser](delete-user.md) | `fun deleteUser(userId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Deletes a user in the database |
| [findUserByEmail](find-user-by-email.md) | `fun findUserByEmail(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MDBUser`](-m-d-b-user/index.md)`?`<br>Gets the user with the specified email |
| [findUserById](find-user-by-id.md) | `fun findUserById(id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`MDBUser`](-m-d-b-user/index.md)`?`<br>Gets the user with the specified id |
| [getUsers](get-users.md) | `fun getUsers(users: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MDBUser`](-m-d-b-user/index.md)`>`<br>Gets all users within a list of id |
| [newUser](new-user.md) | `fun newUser(user: `[`MDBUser`](-m-d-b-user/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Creates a new user in the database |
| [removeAssociation](remove-association.md) | `fun removeAssociation(userId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, associateId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Removes the specified associate from the specified users associations |
| [updateDisplayName](update-display-name.md) | `fun updateDisplayName(userId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, newDisplayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Updates the display name of the specified user |
| [updateStatus](update-status.md) | `fun updateStatus(userId: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, newStatus: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Updates the status of the specified user |
