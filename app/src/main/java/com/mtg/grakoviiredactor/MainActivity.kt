package com.mtg.grakoviiredactor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private val entityFragment = EntityFragment.newInstance()
    private val individualsFragment = IndividualsFragment.newInstance()
    private val searchFragment = SearchFragment.newInstance()
    private val settingsFragment = SettingsFragment.newInstance()

    private lateinit var mainProgressBar: ProgressBar
    private lateinit var mainProgressText: MaterialTextView

    private val bottomListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.entities -> {
                loadFragment(entityFragment)
                true
            }
            R.id.individuals -> {
                loadFragment(individualsFragment)
                true
            }
            R.id.search -> {
                loadFragment(searchFragment)
                true
            }
            R.id.settings -> {
                loadFragment(settingsFragment)
                true
            }
            else -> false
        }
    }

    private fun loadFragment(fragment: Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.mainFragment, fragment)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainProgressBar = findViewById(R.id.mainProgressBar)
        mainProgressText = findViewById(R.id.mainProgressText)
        loadFragment(entityFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.mainBottomView)
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomListener)
    }

}