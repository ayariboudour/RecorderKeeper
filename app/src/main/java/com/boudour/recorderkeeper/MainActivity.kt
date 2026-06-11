package com.boudour.recorderkeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.fragment.app.commit
import com.boudour.recorderkeeper.cycling.CyclingFragement
import com.boudour.recorderkeeper.databinding.ActivityMainBinding
import com.boudour.recorderkeeper.running.RunningFragement
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val menuClickedHandled =
            when (item.itemId) {
                R.id.reset_running -> {
                    getSharedPreferences("running", MODE_PRIVATE).edit { clear() }
                    true
                }

                R.id.reset_cycling -> {
                    getSharedPreferences("cycling", MODE_PRIVATE).edit { clear() }
                    true
                }

                R.id.reset_all -> {
                    getSharedPreferences("running", MODE_PRIVATE).edit { clear() }
                    getSharedPreferences("cycling", MODE_PRIVATE).edit { clear() }
                    true
                }

                else -> {
                    super.onOptionsItemSelected(item)
                }

            }
        when (binding.bottomNav.selectedItemId) {
            R.id.nav_cycling -> onCyclingClicked()
            R.id.nav_running -> onRunningClicked()
        }
        return menuClickedHandled
    }

    private fun onRunningClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_contentt, RunningFragement())
        }
        return true
    }

    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_contentt, CyclingFragement())
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.nav_cycling -> onCyclingClicked()
        R.id.nav_running -> onRunningClicked()
        else -> false
    }
}