package com.boudour.recorderkeeper.cycling

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boudour.recorderkeeper.databinding.FragementCyclingBinding
import com.boudour.recorderkeeper.editRecord.EditRecordActivity

class CyclingFragement : Fragment() {
    private lateinit var binding: FragementCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragementCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        displayCyclingRecords()
    }

    private fun displayCyclingRecords() {
        val cyclingPreferences =
            requireContext().getSharedPreferences("cycling", Context.MODE_PRIVATE)

        binding.textViewLongestRideValue.text =
            cyclingPreferences.getString("Longest Ride record", null)
        binding.textViewLongestRideDate.text =
            cyclingPreferences.getString("Longest Ride date", null)
        binding.textViewBiggestClimbValue.text =
            cyclingPreferences.getString("Biggest Climb record", null)
        binding.textViewBiggestClimbDate.text =
            cyclingPreferences.getString("Biggest Climb date", null)
        binding.textViewBestAverageSpeedValue.text =
            cyclingPreferences.getString("Best Average Speed record", null)
        binding.textViewBestAverageSpeedDate.text =
            cyclingPreferences.getString("Best Average Speed date", null)
    }

    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener {
            launchCyclingRecordScreen(
                "Longest Ride",
                "Distance"
            )
        }
        binding.containerBiggestClimb.setOnClickListener {
            launchCyclingRecordScreen(
                "Biggest Climb",
                "Height"
            )
        }
        binding.containerBestAverageSpeed.setOnClickListener {
            launchCyclingRecordScreen(
                "Best Average Speed",
                "Average Speed"
            )
        }
    }

    private fun launchCyclingRecordScreen(record: String, recordFieldHint: String) {
        val intent = Intent(context, EditRecordActivity::class.java)
        intent.putExtra(
            "screen_data",
            EditRecordActivity.ScreenData(record, "cycling", recordFieldHint)
        )
        startActivity(intent)
    }

}