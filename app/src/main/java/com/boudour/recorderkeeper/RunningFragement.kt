package com.boudour.recorderkeeper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boudour.recorderkeeper.databinding.FragementRunningBinding

class RunningFragement : Fragment() {

    private lateinit var binding: FragementRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragementRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners(){
        binding.container5km.setOnClickListener {
            launchRunningRecordScreen("5km")
        }
        binding.container10km.setOnClickListener {
            launchRunningRecordScreen("10km")
        }
        binding.containerHalfMarathon.setOnClickListener {
            launchRunningRecordScreen("Half Marathon")
        }
        binding.containerMarathon.setOnClickListener {
            launchRunningRecordScreen("Marathon")
        }
    }

    private fun launchRunningRecordScreen(distance: String) {
       val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }
}