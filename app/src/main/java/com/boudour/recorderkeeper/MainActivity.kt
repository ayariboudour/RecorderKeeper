package com.boudour.recorderkeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.fragment.app.commit
import com.boudour.recorderkeeper.cycling.CyclingFragement
import com.boudour.recorderkeeper.databinding.ActivityMainBinding
import com.boudour.recorderkeeper.running.RunningFragement
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

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
                    showConfirmationDialog(RUNNING_DISPLAY_VALUE)
                    true
                }

                R.id.reset_cycling -> {
                    showConfirmationDialog(CYCLING_DISPLAY_VALUE)
                    true
                }

                R.id.reset_all -> {
                    showConfirmationDialog(ALL_DISPLAY_VALUE)
                    true
                }

                else -> {
                    super.onOptionsItemSelected(item)
                }
            }

        return menuClickedHandled
    }

    private fun showConfirmationDialog(selection: String) {
        AlertDialog.Builder(this)
            .setTitle("Reset $selection Records")
            .setMessage("Are you sure you want to reset records?")
            .setPositiveButton("Yes") { _, _ ->
                when (selection) {
                    RUNNING_DISPLAY_VALUE -> getSharedPreferences(
                        selection,
                        MODE_PRIVATE
                    ).edit { clear() }

                    CYCLING_DISPLAY_VALUE -> getSharedPreferences(
                        selection,
                        MODE_PRIVATE
                    ).edit { clear() }

                    else -> {
                        getSharedPreferences(CYCLING_DISPLAY_VALUE, MODE_PRIVATE).edit { clear() }
                        getSharedPreferences(RUNNING_DISPLAY_VALUE, MODE_PRIVATE).edit { clear() }
                    }
                }
                refresh()
                showConfirmation()
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun showConfirmation() {
        val snackbar =
            Snackbar.make(binding.root, "Record reset successfully", Snackbar.LENGTH_SHORT)
        snackbar.anchorView = binding.bottomNav
        snackbar.setAction("undo") {
            // Undo logic can be implemented here if needed
        }
        snackbar.show()
    }

    private fun refresh() {
        when (binding.bottomNav.selectedItemId) {
            R.id.nav_cycling -> onCyclingClicked()
            R.id.nav_running -> onRunningClicked()
        }
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

    companion object {
        const val RUNNING_DISPLAY_VALUE = "running"
        const val CYCLING_DISPLAY_VALUE = "cycling"
        const val ALL_DISPLAY_VALUE = "all"
    }
}