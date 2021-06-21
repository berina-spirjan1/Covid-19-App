package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_fourteen_question.view.*
import kotlinx.android.synthetic.main.fragment_fourth_question.view.*


class FourthQuestion : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fourth_question, container, false)
        view.yes_4.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fourthQuestion_to_fiveQuestion)
        }
        view.no_4.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fourthQuestion_to_fiveQuestion)
        }
        return view
    }

}