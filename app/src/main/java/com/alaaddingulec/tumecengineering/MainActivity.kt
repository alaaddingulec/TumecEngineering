package com.alaaddingulec.tumecengineering

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.alaaddingulec.tumecengineering.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout


    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)



        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Anasayfa())
                .commit()
            navigationView.setCheckedItem(R.id.navanasayfa)
        }
    }

    private fun setSupportActionBar(header: NavigationView?) {

    }


    @SuppressLint("WrongViewCast")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navanasayfa -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Anasayfa())
                .commit()
            R.id.navprojeler -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Projeler())
                .commit()
            R.id.navreferanslar -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Referanslar())
                .commit()
            R.id.menu_call -> {
                val phoneNumber = "tel:+905452336303"
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
                startActivity(dialIntent)
            }
            R.id.menu_email -> {
                val emailIntent = Intent(Intent.ACTION_SENDTO)
                emailIntent.data = Uri.parse("mailto:")
                emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("alaaddingulec2012@hotmail.com"))
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Konu")
                startActivity(emailIntent)
            }


        }
        drawerLayout.closeDrawers()
        return true




    }
}