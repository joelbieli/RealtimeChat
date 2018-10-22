package user

class FrontendUser (
        var firstName: String,
        var lastName: String,
        var displayName: String,
        var status: String
) {
    object Mapper {
        fun from(user: User) =
                FrontendUser(user.firstName, user.lastName, user.displayName, user.status)
        fun from(user: NewUser) =
                FrontendUser(user.firstName, user.lastName, user.displayName, user.status)
    }
}