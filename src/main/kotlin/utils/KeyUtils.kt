package utils

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import javax.crypto.spec.SecretKeySpec
import org.apache.commons.codec.DecoderException
import org.apache.commons.codec.binary.Hex.decodeHex
import org.apache.commons.codec.binary.Hex.encodeHex
import org.apache.commons.io.FileUtils.readFileToByteArray
import org.apache.commons.io.FileUtils.writeStringToFile
import java.io.IOException
import java.io.File
import java.nio.charset.StandardCharsets
import javax.crypto.SecretKey

class KeyUtils {
    companion object {
        fun getKey(file: File): SecretKey {
            println(file.absolutePath)
            return if (file.exists()) {
                loadKey(file)!!
            } else {
                val newKey = generateKey()
                saveKey(newKey, file)
                newKey
            }
        }

        private fun generateKey(): SecretKey {
            return Keys.secretKeyFor(SignatureAlgorithm.HS256)
        }

        @Throws(IOException::class)
        private fun saveKey(key: SecretKey, file: File) {
            val hex = encodeHex(key.encoded)
            writeStringToFile(file, String(hex), StandardCharsets.UTF_8)
        }

        @Throws(IOException::class)
        private fun loadKey(file: File): SecretKey? {
            val data = String(readFileToByteArray(file))
            val encoded: ByteArray
            try {
                encoded = decodeHex(data.toCharArray())
            } catch (e: DecoderException) {
                e.printStackTrace()
                return null
            }

            return SecretKeySpec(encoded, "HmacSHA256")
        }
    }
}