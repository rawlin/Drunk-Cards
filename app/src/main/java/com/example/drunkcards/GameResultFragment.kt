package com.example.drunkcards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.drunkcards.databinding.FragmentGameResultBinding

class GameResultFragment:Fragment(R.layout.fragment_game_result) {

    private lateinit var binding:FragmentGameResultBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentGameResultBinding.bind(view)

        setDataToView()
    }

    private fun setDataToView() {

    }
}