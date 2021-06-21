package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import ba.unsa.pmf.math.covid_19vaccinationapp.model.User
import ba.unsa.pmf.math.covid_19vaccinationapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.custom_row.*
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import java.util.*

class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        view.sign_in_button.setOnClickListener { //saljemo na taj klik zapisivanje podataka u bazu
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        //pokupimo sve podatke sa unesenih edit polja koji su definisani u navedenom fragmentu i sačuvamo ih u varijable
        val name=name.text.toString()
        val surname=surname.text.toString()
        val vaccine=vaccine.text.toString()
        val cardNumber=card_number.text.toString()
        val profession=profession.text.toString()
        val years=godine.text
        val date=datum.text.toString()
        if(inputCheck(name,surname,vaccine,cardNumber,profession,years,date)){ //ukoliko su sva polja popunjena
            //Kreiramo potom User Object
            val user= User(0,name,surname,vaccine,cardNumber,profession,Integer.parseInt(years.toString()),date)
            //Dodajemo podatke u bazu podataka
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully added user!",Toast.LENGTH_SHORT).show()
            //Navigiramo back, ukoliko je profesija doktor vraćamo se na fragment u kojem se ispisuju svi useri
            if (profession.decapitalize()=="doctor"){
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }
            else{ //ukoliko nije, preskacemo mogucnost uređivanja i navigiramo na posljednji fragment aplikacije
                findNavController().navigate(R.id.action_addFragment_to_thanksFragment)
            }
        }
        else{ //ukoliko neko od polja nije popunjeno ispisujemo prikladnu poruku
            Toast.makeText(requireContext(),"Please fill out all fields!",Toast.LENGTH_SHORT).show()
        }
    }
    //provjeravamo da li su unesena polja popunjena
    private fun inputCheck(name: String, surname: String, vaccine: String, cardNumber: String, profession: String, years: Editable, date: String):Boolean{
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(surname) || TextUtils.isEmpty(vaccine) || TextUtils.isEmpty(cardNumber)
                || TextUtils.isEmpty(profession) || TextUtils.isEmpty(years) || TextUtils.isEmpty(date))
    }

}