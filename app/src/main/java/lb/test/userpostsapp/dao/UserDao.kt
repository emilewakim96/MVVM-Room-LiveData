package lb.test.userpostsapp.dao

import androidx.room.*
import lb.test.userpostsapp.model.UserEntity

@Dao
abstract class UserDao {
    @Query("SELECT * FROM user")
    abstract fun getUser(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(vararg user: UserEntity)
}