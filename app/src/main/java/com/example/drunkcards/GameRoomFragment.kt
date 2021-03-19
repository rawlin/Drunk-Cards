package com.example.drunkcards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.drunkcards.adapters.PlayersAdapter
import com.example.drunkcards.databinding.FragmentGameRoomBinding
import com.example.drunkcards.mockData.MockData
import com.example.drunkcards.utils.Constants

class GameRoomFragment :Fragment(){
    lateinit var binding:FragmentGameRoomBinding
    lateinit var playersAdapter: PlayersAdapter
    lateinit var gameType:String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentGameRoomBinding.inflate(inflater,container,false)
        gameType= arguments?.getString(Constants.PUBLIC_PRIVATE_ROOM,"").toString()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when(gameType){
            "public"-> binding.tvDumb.text="Create or Join Public Room"
            "private"-> binding.tvDumb.text="Create or Join Private Room"
        }
        playersAdapter= PlayersAdapter()
        playersAdapter.addDataToAdapter(MockData.getMockedUsers())

        binding.apply {
            rvPlayers.adapter = playersAdapter

            btnStart.setOnClickListener {
                if(gameType=="private")
                    findNavController().navigate(R.id.action_gameRoomFragment_to_cardStackFragment)
                else
                    findNavController().navigate(R.id.action_gameRoomFragment_to_publicGameSchedulerFragment)
            }
        }

    }
}