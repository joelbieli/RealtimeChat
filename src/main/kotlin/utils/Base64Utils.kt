package utils

import org.apache.commons.codec.binary.Base64
import org.litote.kmongo.Id
import org.litote.kmongo.id.WrappedObjectId
import java.nio.charset.Charset

/**
 * This singleton object has two helper functions for encoding an Id<String> object to a Base64 encoded string and back
 */
object Base64Utils {
    fun encodeIdToString(id: Id<String>): String {
        return Base64().encodeToString(id.toString().toByteArray())
    }

    fun decodeStringToId(id: String): Id<String> {
        return WrappedObjectId(Base64().decode(id).toString(Charset.defaultCharset()))
    }
}