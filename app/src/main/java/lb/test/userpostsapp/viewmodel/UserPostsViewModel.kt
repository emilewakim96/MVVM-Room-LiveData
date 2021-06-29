package lb.test.userpostsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import lb.test.userpostsapp.App
import lb.test.userpostsapp.model.Post

class UserPostsViewModel: ViewModel() {

    lateinit var userPosts: LiveData<List<Post>>
    var userId: String = ""

    fun getUserPosts() {
        val postsRepository = App.postsRepository
        userPosts = postsRepository.getUserPosts(userId)
    }

}