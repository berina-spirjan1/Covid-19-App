package ba.unsa.pmf.math.covid_19vaccinationapp.repository

import androidx.lifecycle.LiveData
import ba.unsa.pmf.math.covid_19vaccinationapp.data.UserDao
import ba.unsa.pmf.math.covid_19vaccinationapp.model.User

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }
    suspend fun getNumFiles(): Int {
        return userDao.getNumFiles()
    }
    suspend fun getNumberOfPfizer(): Int {
        return userDao.getNumberOfPfizer()
    }
    suspend fun getNumberOfAstraZeneca():Int {
        return userDao.getNumberOfAstraZeneca()
    }
    suspend fun getNumberOfModerna():Int {
        return userDao.getNumberOfModerna()
    }
    suspend fun getNumberOfJohnson():Int{
        return userDao.getNumberOfJohnson()
    }
    suspend fun getNumberOfSinopharm():Int{
        return userDao.getNumberOfSinopharm()
    }
    suspend fun getNumberOfSinovac():Int{
        return userDao.getNumberOfSinovac()
    }
    suspend fun getNumberOfSputnjik():Int{
        return userDao.getNumberOfSputnjik()
    }
}