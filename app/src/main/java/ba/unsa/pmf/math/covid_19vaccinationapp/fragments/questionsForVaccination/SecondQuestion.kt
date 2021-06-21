package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_second_question.view.*


class SecondQuestion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_question, container, false)
        view.no_2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_secondQuestion_to_stranger)
        }
        view.yes_2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_secondQuestion_to_thirdQuestion)
        }
        return view
    }

}