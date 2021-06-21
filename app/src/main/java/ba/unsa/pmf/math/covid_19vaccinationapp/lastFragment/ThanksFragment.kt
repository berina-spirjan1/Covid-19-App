package ba.unsa.pmf.math.covid_19vaccinationapp.lastFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import ba.unsa.pmf.math.covid_19vaccinationapp.fragments.list.ListAdapter
import ba.unsa.pmf.math.covid_19vaccinationapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ThanksFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_thanks, container, false)
        val adapter = ListAdapter()
        var recyclerView=view.recyclerView
        recyclerView.adapter=adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mUserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {user->
            adapter.setData(user)
        })
        return view
    }


}