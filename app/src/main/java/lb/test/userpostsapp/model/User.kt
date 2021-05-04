package lb.test.userpostsapp.model

import java.util.*

data class User(
    val firstName: String,
    val lastName: String
) {
    fun mapToDBEntity() = UserEntity(
        uid = UUID.randomUUID().toString(),
        firstName = firstName,
        lastName = lastName
    )
}