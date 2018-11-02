package utils

import com.kstruct.gethostname4j.Hostname.getHostname
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import logger
import org.litote.kmongo.Id
import java.io.File

/**
 * This singleton object has two helper functions for creating/signing and decoding/verifying a JWT
 */
object JWTUtils {
    // gets the secret key from the specified file
    private val secret = KeyUtils.getKey(File("./src/main/resources/secret.key"))

    /**
     * A helper function for creating a JWT which will be used for authentication
     *
     * @param _id The id object which will be used as the body of the JWT
     *
     * @return The HmacSHA256 signed JWT
     */
    fun sign(_id: Id<String>): String {
        return Jwts.builder()
                .setIssuer(System.getProperty("os.arch") + "_" + getHostname())
                .setSubject(_id.toString())
                .signWith(secret)
                .compact()!!
    }

    /**
     * A helper function for verifying and returning the contents of a JWT
     *
     * @param token The token to verify and decode
     *
     * @return the decoded JWT
     */
    fun verify(token: String): Jws<Claims>? {
        val decodedJWT: Jws<Claims>?

        try {
            decodedJWT = Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
        } catch (jwtEx: JwtException) {
            logger.error(jwtEx) { "An error occurred during JWT verification" }
            return null
        }

        return decodedJWT!!
    }
}