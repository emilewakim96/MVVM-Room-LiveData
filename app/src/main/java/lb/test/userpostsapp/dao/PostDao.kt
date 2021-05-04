package lb.test.userpostsapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import lb.test.userpostsapp.model.PostEntity

@Dao
abstract class PostDao {
    @Query("Select * from Post where userId = :userId")
    abstract fun getUserPosts(userId: String): LiveData<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertPost(post: PostEntity)
}