package com.example.drunkcards

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.drunkcards.adapters.CommentsAdapter
import com.example.drunkcards.databinding.FragmentTurnEndBinding
import com.example.drunkcards.mockData.MockData

@SuppressLint("SetTextI18n")
class TurnEndFragment :Fragment(R.layout.fragment_turn_end) {
    private lateinit var binding: FragmentTurnEndBinding
    private lateinit var rvAdapter:CommentsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentTurnEndBinding.bind(view)
        rvAdapter= CommentsAdapter()

        setDataToView()
    }

    private fun setDataToView() {
        binding.rvComments.adapter=rvAdapter
        rvAdapter.addDataToAdapter(MockData.getComments())
        val reportCard=MockData.getReportCardAfterATurn()
        binding.toolbarTitle.text=reportCard.taskDoneBy+" 's Scorecard"
        binding.ratingBar.rating=reportCard.ratingGive
        binding.tvUserName.text=reportCard.taskDoneBy+" 's Task"
        binding.tvTaskDescription.text=reportCard.taskDescription
    }
}