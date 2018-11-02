package utils

import io.jsonwebtoken.Jws
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.litote.kmongo.newId

object JWTUtilsSpec: Spek({
    describe("JWT Utils") {
        var jwtString: String
        context("generate new JWT") {
            jwtString = JWTUtils.sign(newId())
            it("should've created a valid JWT") {
                JWTUtils.verify(jwtString) shouldBeInstanceOf Jws::class
            }
            context("part of the JWT is changed") {
                val alteredJWTString = jwtString.replaceRange(0..1, "{}")
                it("should return null, indicating that the JWT is invalid") {
                    JWTUtils.verify(alteredJWTString) shouldEqual null
                }
            }
        }
    }
})