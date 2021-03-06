package it.insubria.protezionet.admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar


class MainActivity : AppCompatActivity() {

    private lateinit var chipNavigationBar: ChipNavigationBar
    private var fragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chipNavigationBar = findViewById(R.id.chipNavigation)

        chipNavigationBar.setItemSelected(R.id.nav_home, true)
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()

        chipNavigationBar.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {

            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.nav_home -> fragment = HomeFragment()
                    R.id.nav_person -> fragment = PersonFragment()
                    R.id.nav_event -> fragment = EventFragment()
                    R.id.nav_team -> fragment = TeamFragment()
                    R.id.nav_truck -> fragment = TruckFragment()
                    R.id.nav_equipment -> fragment = EquipmentFragment()
                }
                if (fragment != null) {
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment!!).commit()
                }
            }
        })


    }//END_onCreate

    /*private fun setUpTabBar() {

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it) {
                R.id.nav_home -> binding.textMain.text = "Home"
                R.id.nav_person -> binding.textMain.text = "Person"
                R.id.nav_event -> {
                    binding.textMain.text = "event"
                    //binding.bottomNavBar.showBadge(R.id.nav_settings)
                }
                R.id.nav_truck -> {
                    binding.textMain.text = "Truck"
                    //binding.bottomNavBar.dismissBadge(R.id.nav_settings)
                }
                R.id.nav_equipment -> {
                    binding.textMain.text = "equipment"
                    //binding.bottomNavBar.dismissBadge(R.id.nav_settings)
                }
            }
        }
    }END_setUpTabBar */
}