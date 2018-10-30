import org.amshove.kluent.shouldEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import user.User

object UserSpec: Spek({
    Feature("The user class") {
        val user = User("jdoe", "some status", "John", "Doe", "john.doe@example.com", password = "abc123.-")
        Scenario ("check password") {
            var passwordOk = false
            beforeEachTest { passwordOk = false }
            When("the correct password is used to check the password") {
                passwordOk = user.checkPW("abc123.-")
            }
            Then("it should return true") {
                passwordOk shouldEqualTo true
            }
            When("an incorrect password is used to check the password") {
                passwordOk = user.checkPW("password")
            }
            Then("it should return false") {
                passwordOk shouldEqualTo false
            }
        }
    }
})