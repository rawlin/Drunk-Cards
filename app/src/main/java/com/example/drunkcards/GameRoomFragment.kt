package com.example.drunkcards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.drunkcards.adapters.PlayersAdapter
import com.example.drunkcards.databinding.FragmentGameRoomBinding
import com.example.drunkcards.mockData.MockData

class GameRoomFragment :Fragment(){
    lateinit var binding:FragmentGameRoomBinding
    lateinit var playersAdapter: PlayersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentGameRoomBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playersAdapter= PlayersAdapter()
        playersAdapter.addDataToAdapter(MockData.getMockedUsers())
        binding.rvPlayers.adapter=playersAdapter

        binding.btnInvite.setOnClickListener{
            Toast.makeText(context,"Clicked",Toast.LENGTH_LONG).show()
        }
    }
}