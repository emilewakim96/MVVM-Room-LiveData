package lb.test.userpostsapp.koin

import lb.test.userpostsapp.repository.PostsRepository
import lb.test.userpostsapp.repository.UsersRepository
import lb.test.userpostsapp.viewmodel.HomeViewModel
import lb.test.userpostsapp.viewmodel.UserPostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { PostsRepository() }
    single { UsersRepository() }
}

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { UserPostsViewModel() }
}
