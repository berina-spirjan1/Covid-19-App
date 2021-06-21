package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_seven_question.view.*
import kotlinx.android.synthetic.main.fragment_six_question.view.*


class SixQuestion : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_six_question, container, false)
        view.yes_6.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_sixQuestion_to_sevenQuestion)
        }
        view.no_6.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_sixQuestion_to_sevenQuestion)
        }
        return view
    }

}