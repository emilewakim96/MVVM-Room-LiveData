package lb.test.userpostsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey val uid: String,
    val firstName: String?,
    val lastName: String?
)