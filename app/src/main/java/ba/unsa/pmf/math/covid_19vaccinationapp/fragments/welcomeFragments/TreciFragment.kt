package ba.unsa.pmf.math.covid_19vaccinationapp.fragments.welcomeFragments

import android.database.DatabaseUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.RoomMasterTable.TABLE_NAME
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_treci.*
import kotlinx.android.synthetic.main.fragment_update.*


class TreciFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_treci, container, false)
        return view
    }
}