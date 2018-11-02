[RealtimeChat](../../index.md) / [utils](../index.md) / [JWTUtils](index.md) / [sign](./sign.md)

# sign

`fun sign(_id: Id<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

A helper function for creating a JWT which will be used for authentication

### Parameters

`_id` - The id object which will be used as the body of the JWT

**Return**
The HmacSHA256 signed JWT

