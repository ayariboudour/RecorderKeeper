package com.boudour.recorderkeeper

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.boudour.recorderkeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCycling.setOnClickListener {
            onCyclingClicked()
        }
        binding.buttonRunning.setOnClickListener {
            onRunningClicked()
        }
    }

    /**
     * add fragement transaction For running
     */
    private fun onRunningClicked() {
        // add fragement transaction
        supportFragmentManager.commit {
            replace(R.id.frame_contentt, RunningFragement())
        }
    }

    /**
     * add fragement transaction For cycling
     */
    private fun onCyclingClicked() {
        // add fragement transaction
        supportFragmentManager.commit {
            replace(R.id.frame_contentt, CyclingFragement())
        }
    }
}