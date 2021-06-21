package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.updates

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import ba.unsa.pmf.math.covid_19vaccinationapp.model.User
import ba.unsa.pmf.math.covid_19vaccinationapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.update_name.setText(args.currentUser.name)
        view.update_surname.setText(args.currentUser.surname)
        view.update_vaccine.setText(args.currentUser.vaccine)
        view.update_card_number.setText(args.currentUser.cardNumber)
        view.update_profession.setText(args.currentUser.profession)
        view.update_year.setText(args.currentUser.years.toString())
        view.update_button.setOnClickListener {
                updateItem()
        }

        //Dodajemo meni
        setHasOptionsMenu(true)
        return view
    }
    private fun updateItem(){
        val name=update_name.text.toString()
        val surname=update_surname.text.toString()
        val vaccine=update_vaccine.text.toString()
        val card_number=update_card_number.text.toString()
        val profession=update_profession.text.toString()
        val years=Integer.parseInt(update_year.text.toString())
        val date=datum1.text.toString()
        if(inputCheck(name,surname,vaccine,card_number,profession,update_year.text,date)) {
            //Kreiramo User objekat
            val updatedUser = User(args.currentUser.id,name,surname,vaccine,card_number,profession, years,date)
            //Uređivanje trenutnog usera
                mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(),"Successfully updated user!",Toast.LENGTH_SHORT).show()
            //Navigiramo povratak
            if (profession.decapitalize()=="doctor"){
                findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            }
            else{
                findNavController().navigate(R.id.action_updateFragment_to_thanksFragment)
            }

        }
        else{
            Toast.makeText(requireContext(),"Please fill out all fields!",Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(name: String, surname: String, vaccine: String, card_number: String, profession: String, years: Editable, date: String):Boolean{
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(surname) || TextUtils.isEmpty(vaccine) || TextUtils.isEmpty(card_number)
                || TextUtils.isEmpty(profession) || TextUtils.isEmpty(years)|| TextUtils.isEmpty(date))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }
    //U ovoj funkciji definišemo svu logiku vezanu za brisanje usera
    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        //sada provjeravamo nakon što ljekar pritisne delete dugme, da li doista želi obrisati tog usera
        builder.setNegativeButton("No"){_,_->}
        builder.setPositiveButton("Yes"){_,_->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(),"Successfully removed: ${args.currentUser.name}!",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }

        builder.setTitle("Delete ${args.currentUser.name}?")
        builder.setMessage("Are you sure that you want to delete ${args.currentUser.name}?")
        builder.create().show()

    }
}