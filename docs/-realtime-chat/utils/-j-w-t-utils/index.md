[RealtimeChat](../../index.md) / [utils](../index.md) / [JWTUtils](./index.md)

# JWTUtils

`object JWTUtils`

This singleton object has two helper functions for creating/signing and decoding/verifying a JWT

### Functions

| Name | Summary |
|---|---|
| [sign](sign.md) | `fun sign(_id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A helper function for creating a JWT which will be used for authentication |
| [verify](verify.md) | `fun verify(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Jws<Claims>?`<br>A helper function for verifying and returning the contents of a JWT |
