package com.example.drunkcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentTransaction
import com.example.drunkcards.databinding.FragmentGamePlayBinding
import java.security.Permissions


class GamePlayFragment : Fragment(R.layout.fragment_game_play) {

    lateinit var binding: FragmentGamePlayBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGamePlayBinding.bind(view)

        setupCameraFragment()

    }

    private fun setupCameraFragment() {
        val childFragment = CameraFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.camera_framgent_container, childFragment).commit()
    }
}