package com.boudour.recorderkeeper.running

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.boudour.recorderkeeper.databinding.ActivityEditRunningRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditRunningRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val distance = intent.getStringExtra("Distance")
        title = "$distance Record"

        // 1. Load the record when the activity starts
        displayRecord(distance)

        binding.buttonSave.setOnClickListener {
            saveRecord(distance)
            finish() // Go back to the previous screen after saving
        }
    }

    private fun displayRecord(distance: String?) {
        val runningPreference = getSharedPreferences("running", Context.MODE_PRIVATE)
        binding.editTextRecord.setText(runningPreference.getString("$distance record", null))
        binding.editTextDate.setText(runningPreference.getString("$distance date", null))
    }

    private fun saveRecord(distance: String?) {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        val runningPreference = getSharedPreferences("running", Context.MODE_PRIVATE)
        runningPreference.edit {
            putString("$distance record", record)
            putString("$distance date", date)
        }
    }
}