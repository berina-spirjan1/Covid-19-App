package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_sixteen_question.view.*
import kotlinx.android.synthetic.main.fragment_third_question.view.*


class ThirdQuestion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_question, container, false)
        view.yes_3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_thirdQuestion_to_positiveOnCovid)
        }
        view.no_3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_thirdQuestion_to_fourthQuestion)
        }
        return view
    }


}