package com.example.drunkcards

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.drunkcards.adapters.CommentsAdapter
import com.example.drunkcards.adapters.GameResultsAdapter
import com.example.drunkcards.databinding.FragmentTurnEndBinding
import com.example.drunkcards.mockData.MockData
import com.example.drunkcards.models.MatchResultForAPlayer

@SuppressLint("SetTextI18n")
class TurnEndFragment :Fragment(R.layout.fragment_turn_end) {
    private lateinit var binding: FragmentTurnEndBinding
    private lateinit var rvAdapter:CommentsAdapter
    private lateinit var rvLeaderShipBoards:GameResultsAdapter
    private lateinit var handler:Handler
    private lateinit var runnable: Runnable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentTurnEndBinding.bind(view)
        rvAdapter= CommentsAdapter()

        setDataToView()
    }

    private fun setDataToView() {
        rvLeaderShipBoards= GameResultsAdapter(hideTurnsCount = false)
        binding.rvRankBoard.adapter=rvLeaderShipBoards
        var results=MockData.getResultAfterAMatch()
        results= results.sortedWith(object:Comparator<MatchResultForAPlayer>{
            override fun compare(o1: MatchResultForAPlayer, o2: MatchResultForAPlayer): Int {
                return o2.userPoints-o1.userPoints
            }

        })
        rvLeaderShipBoards.addDataToAdapter(results)

        binding.rvComments.adapter=rvAdapter
        rvAdapter.addDataToAdapter(MockData.getComments())
        val reportCard=MockData.getReportCardAfterATurn()
        binding.toolbarTitle.text=reportCard.taskDoneBy+" 's Scorecard"
        binding.ratingBar.rating=reportCard.ratingGive
        binding.tvUserName.text=reportCard.taskDoneBy+" 's Task"
        binding.tvTaskDescription.text=reportCard.taskDescription

         handler=Handler()
        runnable=Runnable {
            findNavController().navigate(R.id.action_turnEndFragment_to_gameResultFragment)
        }
        handler.postDelayed(runnable,3000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(runnable)
    }
}