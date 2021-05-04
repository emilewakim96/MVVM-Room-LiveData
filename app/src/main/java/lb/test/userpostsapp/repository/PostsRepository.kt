package lb.test.userpostsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import lb.test.userpostsapp.App
import lb.test.userpostsapp.AppDatabase
import lb.test.userpostsapp.model.Post

class PostsRepository {

    fun getUserPosts(userId: String): LiveData<List<Post>> {
        val dbData = getUserPostsFromDb(userId)
        CoroutineScope(Dispatchers.IO).launch {
            getUserPostsFromServer(userId)
        }
        return dbData
    }

    private suspend fun getUserPostsFromServer(userId: String) {
        delay(2000)
        AppDatabase.getDatabase(App.instance.applicationContext).postDao()
            .insertPost(Post("Post 1", "This is the first post description").mapToDBEntity(userId))
    }

    private fun getUserPostsFromDb(userId: String): LiveData<List<Post>> {
        return AppDatabase.getDatabase(App.instance.applicationContext).postDao().getUserPosts(userId)
            .map { listEntities -> listEntities.map { it.mapToDomainModel() } }
    }
}