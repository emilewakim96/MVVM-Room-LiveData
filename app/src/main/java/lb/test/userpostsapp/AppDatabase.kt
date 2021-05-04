package lb.test.userpostsapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import lb.test.userpostsapp.dao.PostDao
import lb.test.userpostsapp.dao.UserDao
import lb.test.userpostsapp.model.PostEntity
import lb.test.userpostsapp.model.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun postDao(): PostDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "database-name"
                ).build()
            }
            return INSTANCE as AppDatabase
        }
    }
}