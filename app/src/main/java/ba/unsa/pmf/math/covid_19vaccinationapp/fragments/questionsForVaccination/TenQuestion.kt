package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.questionsForVaccination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_eight_question.view.*
import kotlinx.android.synthetic.main.fragment_ten_question.view.*


class TenQuestion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ten_question, container, false)
        view.yes_10.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_tenQuestion_to_elevenQuestion)
        }
        view.no_10.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_tenQuestion_to_elevenQuestion)
        }
        return view
    }

}