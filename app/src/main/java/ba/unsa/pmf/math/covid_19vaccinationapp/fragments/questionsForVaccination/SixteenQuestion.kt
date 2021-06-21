package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_sixteen_question.view.*


class SixteenQuestion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sixteen_question, container, false)
        view.no_16.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_sixteenQuestion_to_pregnent)
        }
        view.yes_16.setOnClickListener {
            view.dalje2.isVisible=!view.dalje2.isVisible
        }
        return view
    }

}