package utils

import org.apache.commons.codec.binary.Base64
import org.litote.kmongo.Id
import org.litote.kmongo.id.WrappedObjectId
import java.nio.charset.Charset

class Base64Utils {
    companion object {
        fun encodeIdToString(id: Id<String>): String {
            return Base64().encodeToString(id.toString().toByteArray())
        }

        fun decodeStringToId(id: String): Id<String> {
            return WrappedObjectId(Base64().decode(id).toString(Charset.defaultCharset()))
        }
    }
}