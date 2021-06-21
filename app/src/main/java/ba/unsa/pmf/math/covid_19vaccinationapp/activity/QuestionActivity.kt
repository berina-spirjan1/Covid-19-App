package ba.unsa.pmf.math.covid_19vaccinationapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import ba.unsa.pmf.math.covid_19vaccinationapp.Timer
import timber.log.Timber

const val KEY_TIMER_SECONDS = "timer_seconds_key"

class QuestionActivity : AppCompatActivity() {
    lateinit var Timer: Timer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        Timer = Timer(this.lifecycle)
        if (savedInstanceState != null) {
            Timer.secondsCount = savedInstanceState.getInt(KEY_TIMER_SECONDS, 0)
        }
    }
    fun idi_na_prijavu(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}