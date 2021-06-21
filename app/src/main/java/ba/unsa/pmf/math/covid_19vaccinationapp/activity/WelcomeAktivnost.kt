package ba.unsa.pmf.math.covid_19vaccinationapp.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import ba.unsa.pmf.math.covid_19vaccinationapp.CountryData
import ba.unsa.pmf.math.covid_19vaccinationapp.R

class WelcomeAktivnost : AppCompatActivity() {

    lateinit var zastave:ImageView
    lateinit var spinner:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_aktivnost)
        spinner=findViewById<Spinner>(R.id.spinner)
        zastave=findViewById<ImageView>(R.id.zastava)

        spinner.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            CountryData.naziviDrzava
        )
    }
    fun dalje(view: View) {
        val intent = Intent(this, FirstActivity::class.java)
        startActivity(intent)
    }
    /*on click funkcija koja nam salje intent kako bismo mogli omogućiti poziv na broj, no kako bismo zahtjev ispunili do kraja
    * neophodno je da u manifestu dodamo uses-persmission*/
    fun nazovi(v: View?) {
        val intent = Intent(Intent.ACTION_DIAL)
        val temp = "tel:033365652"
        intent.data = Uri.parse(temp)
        startActivity(intent)
    }
    /*na isti način to uradimo i kod slanja poruke, s tim da unaprijed možemo definisati tekst koji je najvjerovatniji za slanje na broj, koji
    * je moguće uređivati prije slanja na broj*/
    fun posaljiPoruku(v: View?) {
        val smsNumber: String = "062 842 265"
        val smsText: String = "Zdravo. " +
                "Želim Vam prijaviti da imam simptome Covid-19, te zakazati termin za testiranje. " +
                "Unaprijed hvala na odgovoru." +
                " S poštovanjem."

        val uri = Uri.parse("smsto:$smsNumber")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", smsText)
        startActivity(intent)
    }

}