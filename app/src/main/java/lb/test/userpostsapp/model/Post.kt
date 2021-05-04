package lb.test.userpostsapp.model

import java.util.*

data class Post(
    val title: String,
    val description: String
) {
    fun mapToDBEntity(userId: String) = PostEntity(
        pid = UUID.randomUUID().toString(),
        userId = userId,
        title = title,
        description = description
    )
}