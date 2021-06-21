package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_eight_question.view.*

class EightQuestion : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_eight_question, container, false)
        view.yes_8.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_eightQuestion_to_positiveOnCovid)
        }
        view.no_8.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_eightQuestion_to_nineQuestion)
        }
        return view
    }
}