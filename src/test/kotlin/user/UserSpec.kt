package user

import org.amshove.kluent.*
import org.apache.commons.codec.binary.Base64
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.litote.kmongo.Id
import org.mindrot.jbcrypt.BCrypt
import utils.sign

object UserTest: Spek({
    val user = User_old("jdoe", "some status", "John", "Doe", "john.doe@example.com", password = "abc123.-")

    describe("The user class") {
        context("created a new user with primary constructor") {
            given("a user with all fields filled") {
                it("should have 'John' as the value for first name") {
                    user.firstName shouldBeEqualTo "John"
                }
                it("should have 'Doe' as the value for last name") {
                    user.lastName shouldBeEqualTo "Doe"
                }
                it("should have 'john.doe@example.com' as the value for email") {
                    user.email shouldBeEqualTo "john.doe@example.com"
                }
                it("should have 'abc123.-' as the value for password") {
                    user.password shouldBeEqualTo "abc123.-"
                }
                it("should have a hash of 'abc123.-' with a random salt as the value for hash") {
                    BCrypt.checkpw("abc123.-", user.hash) shouldBe true
                }
                it("should have 'jdoe' as the value for display name") {
                    user.displayName shouldBeEqualTo "jdoe"
                }
                it("should have 'some status' as the value for status") {
                    user.status shouldBeEqualTo "some status"
                }
                it("should have a random new id as the value for _id") {
                    user._id shouldBeInstanceOf Id::class
                }
                it("should have a empty string as the value for frontend id") {
                    user.frontendId.shouldBeBlank()
                }
                it("should have an empty string as the value for jwt") {
                    user.jwt.shouldBeBlank()
                }
            }
        }

        context("check password") {
            given("the correct password is used to check the password") {
                val passwordOk = user.checkPW("abc123.-")
                it("should return true") {
                    passwordOk shouldEqualTo true
                }
            }
            given("an incorrect password is used to check the password") {
                val passwordOk = user.checkPW("password")
                it("should return false") {
                    passwordOk shouldEqualTo false
                }
            }
        }

        context("transform the user to a frontend user") {
            given("a user with all fields filled") {
                val frontendUser = user.toFrontendUser()
                it("should have an empty string as the value for first name") {
                    frontendUser.firstName.shouldBeBlank()
                }
                it("should have an empty string as the value for last name") {
                    frontendUser.lastName.shouldBeBlank()
                }
                it("should have an empty string as the value for email") {
                    frontendUser.email.shouldBeBlank()
                }
                it("should have an empty string as the value for password") {
                    frontendUser.password.shouldBeBlank()
                }
                it("should have an empty string as the value for jwt") {
                    frontendUser.jwt.shouldBeBlank()
                }
                it("should have an empty string as the value for hash") {
                    frontendUser.hash.shouldBeBlank()
                }
                it("should have the display name of user as the value for display name") {
                    frontendUser.displayName shouldBeEqualTo user.displayName
                }
                it("should have the status of user as the value for status") {
                    frontendUser.status shouldBeEqualTo user.status
                }
                it("should have a Base64 encoded version of _id of user as the value for frontend id") {
                    frontendUser.frontendId shouldBeEqualTo Base64().encodeAsString(user._id.toString().toByteArray())
                }
                it("should have a random new id as the value for _id") {
                    frontendUser._id shouldBeInstanceOf Id::class
                }
            }
        }

        context("transform the user to a response user") {
            given("a user with all fields filled") {
                val responseUser = user.toResponseUser()
                it("should have an empty string as the value for password") {
                    responseUser.password.shouldBeBlank()
                }
                it("should have an empty string as the value for password") {
                    responseUser.frontendId.shouldBeBlank()
                }
                it("should have an empty string as the value for hash") {
                    responseUser.hash.shouldBeBlank()
                }
                it("should have the display name of user as the value for display name") {
                    responseUser.displayName shouldBeEqualTo user.displayName
                }
                it("should have the status of user as the value for status") {
                    responseUser.status shouldBeEqualTo user.status
                }
                it("should have the first name of user as the value for first name") {
                    responseUser.firstName shouldBeEqualTo user.firstName
                }
                it("should have the last name of user as the value for last name") {
                    responseUser.lastName shouldBeEqualTo user.lastName
                }
                it("should have the email of user as the value for email") {
                    responseUser.email shouldBeEqualTo user.email
                }
                it("should have the id of user signed as a jwt as the value for jwt") {
                    responseUser.jwt shouldBeEqualTo sign(user._id)
                }
                it("should have a random new id as the value for _id") {
                    responseUser._id shouldBeInstanceOf Id::class
                }
            }
        }
    }
})