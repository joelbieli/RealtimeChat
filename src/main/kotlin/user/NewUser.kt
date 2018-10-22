package user

data class NewUser (
        val firstName: String,
        val lastName: String,
        val displayName: String,
        val status: String,
        val email: String,
        val password: String
)