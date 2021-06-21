package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import ba.unsa.pmf.math.covid_19vaccinationapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        //Recyclerview
        val adapter = ListAdapter()
        val recyclerView=view.recyclerView
        recyclerView.adapter=adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {user->
        adapter.setData(user)
        })
        view.buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        //dodajemo meni
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            deleteAllUsers()
        }
        return super.onOptionsItemSelected(item)
    }
    //ovdje implementiramo logiku za brisanje svih usera, tj. uklanjanje svih podataka iz baze
    private fun deleteAllUsers() {
        val builder = AlertDialog.Builder(requireContext())
        //sada provjeravamo nakon što ljekar pritisne delete dugme, da li doista želi obrisati sve usere
        builder.setNegativeButton("No"){_,_->}
        builder.setPositiveButton("Yes"){_,_->
            mUserViewModel.deleteAllUsers()
            Toast.makeText(requireContext(),"Successfully removed all users!",
                Toast.LENGTH_SHORT).show()
        }

        builder.setTitle("Delete all users?")
        builder.setMessage("Are you sure that you want to delete all users?")
        builder.create().show()
    }
}