package ba.unsa.pmf.math.covid_19vaccinationapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import kotlinx.android.synthetic.main.fragment_add.*
import java.util.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupActionBarWithNavController(findNavController(R.id.fragment1))

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController=findNavController(R.id.fragment1)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun share(view: View){
        val intent=Intent(Intent.ACTION_SEND)
        intent.type="type/palin"
        val textBody="Vaccination"
        val shareSubject="Thank you for successfully applying for the COVID-19 vaccine."
        intent.putExtra(Intent.EXTRA_SUBJECT,textBody)
        intent.putExtra(Intent.EXTRA_TEXT,shareSubject)
        startActivity(Intent.createChooser(intent,"Share your information"))
    }



}