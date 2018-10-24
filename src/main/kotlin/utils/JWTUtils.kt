package utils

import logger
import java.io.File
import com.kstruct.gethostname4j.Hostname.getHostname
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts

private val secret = KeyUtils.getKey(File("./src/main/resources/secret.key"))

fun sign(email: String): String {
    return Jwts.builder()
            .setIssuer(System.getProperty("os.arch") + "_" + getHostname())
            .setSubject(email)
            .signWith(secret)
            .compact()!!
}

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