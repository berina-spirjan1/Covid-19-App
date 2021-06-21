package ba.unsa.pmf.math.covid_19vaccinationapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import ba.unsa.pmf.math.covid_19vaccinationapp.model.User

/*UserDao interfejs sadrži metode koje su nam neophodne za pristup bazi podataka*/
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    //pomoću ovog upita uklanjamo sve usere iz baze podataka
    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    //pomoću ovog upita sortiramo sve usere prilikom ispisivanja na osnovu unesenih godina u opadajućem poretku
    //jer se vakcinacija prvo odnosi na stariju populaciju
    @Query("SELECT * FROM user_table ORDER BY years DESC")
    fun readAllData():LiveData<List<User>>

    //pomocu ovog upita cemo izvojiti ukupan broj prijavljenih za vakcinaciju
    @Query("SELECT COUNT(id) FROM user_table")
    fun getNumFiles(): Int

    //pomocu ovoga upita cemo izdvojiti ukupan broj prijavljenih za vakcinaciju Pfizerovom vakcinom
    @Query("SELECT COUNT(id) FROM user_table WHERE vaccine='pfizer' or vaccine='biontech'")
    fun getNumberOfPfizer():Int

    //pomocu ovoga upita cemo izdvojiti ukupan broj prijavljenih za vakcinaciju Moderna vakcinom
    @Query("SELECT COUNT(id) FROM user_table WHERE vaccine='moderna'")
    fun getNumberOfModerna():Int

    //pomocu ovoga upita cemo izdvojiti ukupan broj prijavljenih za vakcinaciju AstraZeneca vakcinom
    @Query("SELECT COUNT(id) FROM user_table WHERE vaccine='astra zeneca' or vaccine='astrazeneca'")
    fun getNumberOfAstraZeneca():Int

    //pomocu ovoga upita cemo izdvojiti ukupan broj prijavljenih za vakcinaciju Johnson vakcinom
    @Query("SELECT COUNT(id) FROM user_table WHERE vaccine='johnson' or vaccine='johnson & johnson' or vaccine='janssen'")
    fun getNumberOfJohnson():Int

    //pomocu ovoga upita cemo izdvojiti ukupan broj prijavljenih za vakcinaciju Sinopharm vakcinom
    @Query("SELECT COUNT(id) FROM user_table WHERE vaccine='sinopharm'")
    fun getNumberOfSinopharm():Int

    //pomocu ovoga upita cemo izdvojiti ukupan broj prijavljenih za vakcinaciju Sinovac vakcinom
    @Query("SELECT COUNT(id) FROM user_table WHERE vaccine='sinovac'")
    fun getNumberOfSinovac():Int

    //pomocu ovoga upita cemo izdvojiti ukupan broj prijavljenih za vakcinaciju Sputnjik V vakcinom
    @Query("SELECT COUNT(id) FROM user_table WHERE vaccine='sputnjikv' or vaccine='sputnik' or vaccine='sputnik v' or vaccine='sputnjik v'")
    fun getNumberOfSputnjik():Int
}