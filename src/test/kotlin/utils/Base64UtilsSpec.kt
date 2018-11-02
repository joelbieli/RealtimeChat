package utils

import org.amshove.kluent.shouldBeEqualTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.litote.kmongo.Id
import org.litote.kmongo.id.WrappedObjectId

object Base64UtilsSpec: Spek({
    describe("Base64 Utils") {
        val id = WrappedObjectId<String>("507f191e810c19729de860ea")
        context("encode an id, then decode it again") {
            val encodedId: String = Base64Utils.encodeIdToString(id)
            val decodedStringId: Id<String> = Base64Utils.decodeStringToId(encodedId)
            it("should contain the same id in decodedStringId as the original id") {
                decodedStringId.toString() shouldBeEqualTo id.toString()
            }
        }
    }
})