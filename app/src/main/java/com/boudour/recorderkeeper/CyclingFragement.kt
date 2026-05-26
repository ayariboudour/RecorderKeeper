package com.boudour.recorderkeeper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boudour.recorderkeeper.databinding.FragementCyclingBinding

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

    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener { launchCyclingRecordScreen("Longest Ride") }
        binding.containerBiggestClimb.setOnClickListener { launchCyclingRecordScreen("Biggest Climb") }
        binding.containerBestAverageSpeed.setOnClickListener { launchCyclingRecordScreen("Best Average Speed") }
    }

    private fun launchCyclingRecordScreen(distance: String) {
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }

}