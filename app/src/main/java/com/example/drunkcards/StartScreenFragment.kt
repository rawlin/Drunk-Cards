package com.example.drunkcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.drunkcards.databinding.FragmentStartScreenBinding
import com.example.drunkcards.utils.Constants
import com.example.drunkcards.utils.Constants.PRIVATE_ROOM
import com.example.drunkcards.utils.Constants.PUBLIC_ROOM


class StartScreenFragment : Fragment(R.layout.fragment_start_screen) {
    private lateinit var binding: FragmentStartScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStartScreenBinding.bind(view)


        binding.apply {
            privateRoomButton.setOnClickListener {
                val bundle = Bundle().apply {
                    putString(PRIVATE_ROOM, PRIVATE_ROOM)
                }
                findNavController().navigate(
                    R.id.action_startScreenFragment_to_gameRoomFragment,
                    bundle
                )
            }

            publicRoomButton.setOnClickListener {
                val bundle = Bundle().apply {
                    putString(PUBLIC_ROOM, PUBLIC_ROOM)
                }
                findNavController().navigate(
                    R.id.action_startScreenFragment_to_gameRoomFragment,
                    bundle
                )
            }
        }


    }
}