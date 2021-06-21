package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_eight_question.view.*
import kotlinx.android.synthetic.main.fragment_first_question.view.*


class FirstQuestion : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first_question, container, false)
        view.yes_1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstQuestion_to_underEighteen)
        }
        view.no_1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstQuestion_to_secondQuestion)
        }
        return view
    }

}

