package ba.unsa.pmf.math.covid_19vaccinationapp.activity
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.MenuItem
import android.view.View
import androidx.annotation.Nullable
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ba.unsa.pmf.math.covid_19vaccinationapp.R
import ba.unsa.pmf.math.covid_19vaccinationapp.viewmodel.UserViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class FirstActivity : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle /*deklarišemo za bočni meni*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*ovaj dio se odnosi na navigacionu traku koja se nalazi u dnu home paga*/
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController= findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)
        val appBarConfiguration= AppBarConfiguration(setOf(
            R.id.prviFragment,
            R.id.drugiFragment,
            R.id.treciFragment
        ))
        setupActionBarWithNavController(navController,appBarConfiguration)
        /*ovdje se zavrsava dio za bottom navigation*/
        /*dio u nastavku se deklariše kako bismo mogli da osposobimo bočni meni, a koji se treba prikazati u sklopu prve aktivnosti na home page*/
        toggle= ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigaciona_traka_sa_strane.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.sign_in -> {
                    val intent = Intent(this, QuestionActivity::class.java)
                    startActivity(intent)
                }
                R.id.share -> {
                    val intent=Intent(Intent.ACTION_SEND)
                    intent.type="type/palin"
                    val textBody="Vaccination"
                    val shareSubject="Thank you for successfully applying for the COVID-19 vaccine."
                    intent.putExtra(Intent.EXTRA_SUBJECT,textBody)
                    intent.putExtra(Intent.EXTRA_TEXT,shareSubject)
                    startActivity(Intent.createChooser(intent,"Share your information"))
                }
                R.id.contact -> {
                    val mBuilder = AlertDialog.Builder(this@FirstActivity)
                    mBuilder.setTitle("Contact")
                    mBuilder.setMessage("OJ DZ Stari Grad – telephone 060 328 04 54\n" +
                            "\n" +
                            "OJ DZ Centar – telephone 060 328 02 17\n" +
                            "\n" +
                            "OJ DZ Novo Sarajevo – telephone 061 165 219\n" +
                            "\n" +
                            "OJ DZ Novi Grad - telephone 033 704 937, 062 274 217\n" +
                            "\n" +
                            "OJ DZ Ilidža – telephone 062 842 265\n" +
                            "\n" +
                            "OJ DZ Hadžići – telephone  060 353 03 04\n" +
                            "\n" +
                            "OJ DZ Vogošća – telephone 033 431 444\n" +
                            "\n" +
                            "OJ DZ Ilijaš – telephone 061 362 096\n" +
                            "\n" +
                            "OJ DZ Trnovo – telephone 033 439 047")
                    val mDialog = mBuilder.create()
                    mDialog.show()
                }
                R.id.send -> {
                    val smsNumber: String = "062 842 265"
                    val smsText: String = "Zdravo. " +
                            "Želim Vam se prijaviti za vakcinisanje protiv COVID-19. " +
                            "Unaprijed hvala na odgovoru." +
                            " S poštovanjem."

                    val uri = Uri.parse("smsto:$smsNumber")
                    val intent = Intent(Intent.ACTION_SENDTO, uri)
                    intent.putExtra("sms_body", smsText)
                    startActivity(intent)
                }
            }
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    /*onClick funckije za odgovarajuće dugmiće*/
    fun prijaviSe(view: View) {
        val intent = Intent(this, QuestionActivity::class.java)
        startActivity(intent)
    }
    fun showChangeLang(view: View) {

        val listItmes = arrayOf("Bosnian", "English")

        val mBuilder = AlertDialog.Builder(this@FirstActivity)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItmes, -1) { dialog, which ->
            if (which == 0) {
                setLocate("bs")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    recreate()
                }
            } else if (which == 1) {
                setLocate("en")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    recreate()
                }
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()

    }

    private fun setLocate(Lang: String) {

        val locale = Locale(Lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        if (language != null) {
            setLocate(language)
        }
    }
}
