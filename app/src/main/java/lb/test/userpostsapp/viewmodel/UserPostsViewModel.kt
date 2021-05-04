package lb.test.userpostsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lb.test.userpostsapp.App
import lb.test.userpostsapp.model.Post
import lb.test.userpostsapp.model.UserEntity

class UserPostsViewModel(val userId: String): ViewModel() {

    val userPosts: LiveData<List<Post>>

    init {
        val postsRepository = App.postsRepository
        userPosts = postsRepository.getUserPosts(userId)
    }

}