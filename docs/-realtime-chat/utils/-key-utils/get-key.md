[RealtimeChat](../../index.md) / [utils](../index.md) / [KeyUtils](index.md) / [getKey](./get-key.md)

# getKey

`fun getKey(file: `[`File`](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)`): `[`SecretKey`](http://docs.oracle.com/javase/6/docs/api/javax/crypto/SecretKey.html)

This functions gets the key from the specified file or creates
and stores a new one if the specified file doesn't exist

### Parameters

`file` - The file in which the key is stored

**Return**
The secret key from the file or the newly generated one

