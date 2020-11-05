package com.codingacademy.navigation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav)
        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)
        actionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigationDrwerOpen,
            R.string.navigationDrwerClose
        ) {
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                //setTitle(R.string.app_name)

            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //setTitle(R.string.app_name)

            }


        }
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        val navigationView: NavigationView = findViewById(R.id.nav)
        navigationView.setNavigationItemSelectedListener(this)
    }


    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }


    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (p0.itemId) {
            R.id.call -> {
                fragment = GeneralFragment.newInstance(p0.itemId, "")
                loadFragment(fragment)
                setTitle(R.string.call_fra)
            }
            R.id.chat -> {
                fragment = GeneralFragment.newInstance(p0.itemId, "")
                loadFragment(fragment)
                setTitle(R.string.chat_fra)
            }
            R.id.status -> {
                fragment = GeneralFragment.newInstance(p0.itemId, "")
                loadFragment(fragment)
                setTitle(R.string.status_fra)
            }
            else -> null

        }
        return true
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .addToBackStack(null)
            .commit()
        drawerLayout.closeDrawer(GravityCompat.START)
    }


}


