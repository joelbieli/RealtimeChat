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

/**
 * This singleton object has some helper functions for handling the secret key used for the JWTs
 */
object KeyUtils {
    /**
     * This functions gets the key from the specified file or creates
     * and stores a new one if the specified file doesn't exist
     *
     * @param file The file in which the key is stored
     *
     * @return The secret key from the file or the newly generated one
     */
    fun getKey(file: File): SecretKey {
        return if (file.exists()) {
            loadKey(file)!!
        } else {
            val newKey = generateKey()
            saveKey(newKey, file)
            newKey
        }
    }

    /**
     * This function generates a new HS265 secret key
     *
     * @return The newly generated key
     */
    private fun generateKey(): SecretKey {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256)
    }

    /**
     * This function saves an existing key to a specified file
     *
     * @param key The key to write to the file
     * @param file The file to write to
     *
     * @throws IOException If there was a problem writing the key to the file
     */
    @Throws(IOException::class)
    private fun saveKey(key: SecretKey, file: File) {
        val hex = encodeHex(key.encoded)
        writeStringToFile(file, String(hex), StandardCharsets.UTF_8)
    }

    /**
     * This function reads the key data from the specified file and converts it to a HmacSHA256 secret key
     *
     * @param file The file in which the key data in contained
     *
     * @return The secret key
     *
     * @throws IOException If the specified file doesn't exist
     */
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