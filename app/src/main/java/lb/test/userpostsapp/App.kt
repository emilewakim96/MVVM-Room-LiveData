package lb.test.userpostsapp

import android.app.Application
import lb.test.userpostsapp.repository.PostsRepository
import lb.test.userpostsapp.repository.UsersRepository

class App: Application() {

    companion object {
        lateinit var postsRepository: PostsRepository
        lateinit var usersRepository: UsersRepository
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        postsRepository = PostsRepository()
        usersRepository = UsersRepository()

        usersRepository.insertUser("1","Emile","Wakim")
    }
}