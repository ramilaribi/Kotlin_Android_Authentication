package tn.esprit.gamerapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
class home : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Set the default fragment
        if (savedInstanceState == null) {
            loadFragment(News())
        }
        // remove alert button from News fragment //



        // remove alert button from News fragment //
    }
    private fun loadFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()





        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.news -> News()
                R.id.store -> Store()
                R.id.profile -> Profile()
                else -> News()
            }

            // Remplacer le fragment actuellement affiché par le fragment sélectionné
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, selectedFragment)
                .commit()

            true
        }

        // Afficher le premier fragment par défaut
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, News())
            .commit()
        val btncart = findViewById<ImageButton>(R.id.chart)
        if (fragment is Store) {
            btncart.visibility = View.VISIBLE
        } else {
            btncart.visibility = View.GONE
        }

    }
}