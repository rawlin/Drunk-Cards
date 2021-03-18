package com.example.drunkcards

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.drunkcards.databinding.FragmentCardStackBinding


class CardStackFragment : Fragment(R.layout.fragment_card_stack) {
    private lateinit var binding: FragmentCardStackBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCardStackBinding.bind(view)



        val cardsStack = mutableListOf<String>("one", "two", "three", "four")





    }
}