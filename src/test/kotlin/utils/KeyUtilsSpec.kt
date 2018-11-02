package utils

import org.amshove.kluent.shouldBeGreaterOrEqualTo
import org.amshove.kluent.shouldEqualTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import java.io.File
import javax.crypto.spec.SecretKeySpec

object KeyUtilsSpec: Spek({
    describe("Key Utils") {
        val tempDir = createTempDir("tmp", "folder", File("./"))
        var generatedKey: SecretKeySpec
        var loadedKey: SecretKeySpec
        context("create new key") {
            generatedKey = KeyUtils.getKey(File(tempDir.absolutePath + "/key")) as SecretKeySpec
            it("should have a key file in the temp folder") {
                tempDir.listFiles().size shouldBeGreaterOrEqualTo 1
            }
            context("load newly generated key") {
                loadedKey = KeyUtils.getKey(File(tempDir.absolutePath + "/key")) as SecretKeySpec
                it("should've return an identical key") {
                    (loadedKey == generatedKey) shouldEqualTo true
                }
            }
        }
        afterGroup { tempDir.deleteRecursively() }
    }
})