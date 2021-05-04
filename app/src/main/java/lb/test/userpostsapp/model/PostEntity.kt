package lb.test.userpostsapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Post",
        foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["uid"],
            childColumns = ["userId"]
        )
])
data class PostEntity(
    @PrimaryKey val pid: String,
    val userId: String,
    val title: String?,
    val description: String?
){
    fun mapToDomainModel() = Post(title = title.toString(), description = description.toString())
}