package ba.unsa.pmf.math.covid_19vaccinationapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//User predstavlja tabelu unutar baze podataka

@Parcelize
@Entity(tableName="user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val surname: String,
    val vaccine: String,
    val cardNumber:String,
    val profession: String,
    val years: Int,
    val date: String
    ):Parcelable