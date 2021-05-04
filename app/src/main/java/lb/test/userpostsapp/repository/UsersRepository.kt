package lb.test.userpostsapp.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import lb.test.userpostsapp.App
import lb.test.userpostsapp.AppDatabase
import lb.test.userpostsapp.model.User
import lb.test.userpostsapp.model.UserEntity

class UsersRepository {

    fun insertUser(id: String, firstName: String, lastName: String) {
        /*insert User in AppDatabase*/
        CoroutineScope(Dispatchers.IO).launch {
            AppDatabase.getDatabase(App.instance.applicationContext).userDao().insert(UserEntity(id, firstName, lastName))
        }
    }
}