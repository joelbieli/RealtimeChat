package utils

import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.kstruct.gethostname4j.Hostname.getHostname
import logger
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.interfaces.DecodedJWT

private const val secret = "x/A?D(G+KbPdSgVk"

fun sign(email: String): String {
    var token: String? = null

    try {
        token = JWT.create()
                .withClaim("email", email)
                .withIssuer(getHostname())
                .sign(Algorithm.HMAC256(secret))
    } catch (exception: JWTCreationException) {
        logger.error(exception) { "An error occurred during JWT signing" }
    }

    return token!!
}

fun verify(token: String): DecodedJWT {
    var decodedJWT: DecodedJWT? = null

    try {
        decodedJWT = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(getHostname())
                .build()
                .verify(token)
    } catch (exception: JWTVerificationException) {
        logger.error(exception) { "An error occurred during JWT verification" }
    }

    return decodedJWT!!
}