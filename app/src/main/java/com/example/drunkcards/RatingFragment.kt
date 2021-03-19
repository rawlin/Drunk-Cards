package com.example.drunkcards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.drunkcards.databinding.FragmentRatingBinding

class RatingFragment : Fragment(R.layout.fragment_rating) {

    private lateinit var binding: FragmentRatingBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRatingBinding.bind(view)

    }
}