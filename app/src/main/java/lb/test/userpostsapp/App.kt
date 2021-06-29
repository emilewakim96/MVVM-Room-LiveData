package lb.test.userpostsapp

import android.app.Application
import android.util.Log
import lb.test.userpostsapp.koin.appModule
import lb.test.userpostsapp.koin.viewModelModule
import lb.test.userpostsapp.repository.PostsRepository
import lb.test.userpostsapp.repository.UsersRepository
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

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
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, viewModelModule))
        }
        postsRepository = get()
        usersRepository = get()

        Log.d("koin", postsRepository.toString())
        Log.d("koin", usersRepository.toString())
        usersRepository.insertUser("1","Emile","Wakim")
    }
}