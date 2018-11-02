[RealtimeChat](../../index.md) / [utils](../index.md) / [KeyUtils](./index.md)

# KeyUtils

`object KeyUtils`

This singleton object has some helper functions for handling the secret key used for the JWTs

### Functions

| Name | Summary |
|---|---|
| [getKey](get-key.md) | `fun getKey(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): `[`SecretKey`](http://docs.oracle.com/javase/6/docs/api/javax/crypto/SecretKey.html)<br>This functions gets the key from the specified file or creates and stores a new one if the specified file doesn't exist |
