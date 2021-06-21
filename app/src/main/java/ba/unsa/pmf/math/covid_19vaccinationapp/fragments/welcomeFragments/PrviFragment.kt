package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.welcomeFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ba.unsa.pmf.math.covid_19vaccinationapp.R

class PrviFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prvi, container, false)
        return view
    }
}