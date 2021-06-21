package ba.unsa.pmf.math.covid_19vaccinationapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ba.unsa.pmf.math.covid_19vaccinationapp.data.UserDatabase
import ba.unsa.pmf.math.covid_19vaccinationapp.model.User
import ba.unsa.pmf.math.covid_19vaccinationapp.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*Omogućava nam komunikaciju između repozitorija i user interfejsa.*/
class UserViewModel(application : Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: UserRepository
    init {
        val userDao= UserDatabase.getDataBase(application).userDao()
        repository= UserRepository(userDao)
        readAllData=repository.readAllData

    }
    fun addUser(user : User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
                repository.updateUser(user)
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
                repository.deleteUser(user)
        }
    }
    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllUsers()
        }
    }
    fun getNumberOfPfizer(){
        viewModelScope.launch(Dispatchers.IO
        ) { repository.getNumberOfPfizer() }
    }
    fun getNumberOfModerna(){
        viewModelScope.launch(Dispatchers.IO
        ) { repository.getNumberOfModerna() }
    }
    fun getNumberOfJohnson(){
        viewModelScope.launch(Dispatchers.IO
        ) { repository.getNumberOfJohnson() }
    }
    fun getNumberOfSinopharm(){
        viewModelScope.launch(Dispatchers.IO
        ) { repository.getNumberOfSinopharm() }
    }
    fun getNumberOfSinovac(){
        viewModelScope.launch(Dispatchers.IO
        ) { repository.getNumberOfSinovac() }
    }
    fun getNumberOfSputnjik(){
        viewModelScope.launch(Dispatchers.IO
        ) { repository.getNumberOfSputnjik() }
    }

}