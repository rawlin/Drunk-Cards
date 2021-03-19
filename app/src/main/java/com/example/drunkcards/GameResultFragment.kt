package com.example.drunkcards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.drunkcards.adapters.GameResultsAdapter
import com.example.drunkcards.databinding.FragmentGameResultBinding
import com.example.drunkcards.mockData.MockData
import com.example.drunkcards.models.MatchResultForAPlayer
import timber.log.Timber

class GameResultFragment:Fragment(R.layout.fragment_game_result) {

    private lateinit var binding:FragmentGameResultBinding
    private lateinit var resultAdapter:GameResultsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentGameResultBinding.bind(view)

        setDataToView()
    }

    private fun setDataToView() {
        resultAdapter= GameResultsAdapter()
        var results=MockData.getResultAfterAMatch()
        results= results.sortedWith(object:Comparator<MatchResultForAPlayer>{
            override fun compare(o1: MatchResultForAPlayer, o2: MatchResultForAPlayer): Int {
                return o2.userPoints-o1.userPoints
            }

        })
        if(results.size>=3){
            val winnerOne= results[0]
            val winnerTwo= results[1]
            val winnerThree= results[2]

            //Timber.d("winner 1 ${winnerOne}, winner 2 $winnerTwo ,winner 3 $winnerThree")
            //todo user avatars with name initials
            Glide.with(binding.winnerOne)
                .load(R.drawable.ic_launcher_background)
                .into(binding.winnerOne)
        }
        binding.btnShare.setOnClickListener{
            //todo implement sharing intent
        }
        resultAdapter.addDataToAdapter(results)
        binding.rvRankBoard.adapter=resultAdapter
    }
}