package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_eight_question.view.*
import kotlinx.android.synthetic.main.fragment_fourteen_question.view.*

class FourteenQuestion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fourteen_question, container, false)
        view.yes_14.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fourteenQuestion_to_fifteenQuestion)
        }
        view.no_14.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fourteenQuestion_to_fifteenQuestion)
        }
        return view
    }

}