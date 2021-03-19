package com.example.drunkcards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.drunkcards.adapters.MatchesAdapter
import com.example.drunkcards.adapters.PlayersAdapter
import com.example.drunkcards.databinding.FragmentPublicGameSchedulerBinding
import com.example.drunkcards.mockData.MockData

class PublicGameSchedulerFragment:Fragment(R.layout.fragment_public_game_scheduler) {

    private lateinit var binding:FragmentPublicGameSchedulerBinding
    private lateinit var participantAdapter:PlayersAdapter
    private lateinit var matchesAdapter:MatchesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPublicGameSchedulerBinding.bind(view)

        setUpTheData()
    }

    private fun setUpTheData() {
        participantAdapter= PlayersAdapter()
        matchesAdapter= MatchesAdapter()

        participantAdapter.addDataToAdapter(MockData.getMockedUsers())
        matchesAdapter.addDataToAdapter(MockData.createSchedule(MockData.getMockedUsers()))

        binding.rvPlayers.adapter=participantAdapter
        binding.rvMatches.adapter=matchesAdapter

        binding.btnStart.setOnClickListener{
            //todo only admin can start the game
            findNavController().navigate(R.id.action_publicGameSchedulerFragment_to_publicGameParticipantsFragment)
        }
    }

}