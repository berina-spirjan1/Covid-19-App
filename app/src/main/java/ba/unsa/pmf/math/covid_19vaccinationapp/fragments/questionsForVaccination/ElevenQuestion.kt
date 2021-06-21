package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_eight_question.view.*
import kotlinx.android.synthetic.main.fragment_eleven_question.view.*

class ElevenQuestion : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_eleven_question, container, false)
        view.yes_11.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_elevenQuestion_to_twelveQuestion)
        }
        view.no_11.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_elevenQuestion_to_twelveQuestion)
        }
        return view
    }

}