package com.boudour.recorderkeeper.editRecord

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.boudour.recorderkeeper.databinding.ActivityEditRecordBinding
import java.io.Serializable

class EditRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding

    private val screenData: ScreenData by lazy {
        @Suppress("DEPRECATION")
        intent.getSerializableExtra("screen_data") as ScreenData
    }

    private val recordPreferences by lazy { getSharedPreferences(screenData.sharedPreferencesName, MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
        displayRecord()
    }

    private fun setupUi() {
        title = "${screenData.record} Record"
        
        // Use the TextInputLayout ID (textInputRecord) instead of the EditText ID
        binding.textInputRecord.hint = screenData.recordFieldHint
        
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            finish()
        }
    }

    private fun displayRecord() {
        binding.editTextRecord.setText(recordPreferences.getString("${screenData.record} record", null))
        binding.editTextDate.setText(recordPreferences.getString("${screenData.record} date", null))
    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        recordPreferences.edit {
            putString("${screenData.record} record", record)
            putString("${screenData.record} date", date)
        }
    }

    private fun clearRecord() {
        recordPreferences.edit {
            remove("${screenData.record} record")
            remove("${screenData.record} date")
        }
    }
    
    data class ScreenData(
        val record: String,
        val sharedPreferencesName: String,
        val recordFieldHint: String,
    ): Serializable
}
