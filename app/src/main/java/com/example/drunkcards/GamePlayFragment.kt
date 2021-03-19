package com.example.drunkcards

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drunkcards.adapters.MessagesAdapter
import com.example.drunkcards.databinding.FragmentGamePlayBinding
import com.example.drunkcards.mockData.MockData
import com.example.drunkcards.models.Comment
import java.security.Permissions


class GamePlayFragment : Fragment(R.layout.fragment_game_play) {

    lateinit var binding: FragmentGamePlayBinding
    lateinit var adapter: MessagesAdapter
    private var messageItemCounter = 0
    private val commentList = mutableListOf<Comment>()
    private lateinit var timer: CountDownTimer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGamePlayBinding.bind(view)

        setupCameraFragment()
        val mockData = MockData.getFakeTasks(60).get(0)
        binding.apply {
            cardContainer.apply {
                tvTaskHead.text = mockData.title
                tvTaskDescription.text = mockData.description
            }

            imageButton.setOnClickListener {
                messageItemCounter++
                val text = editTextMessages.text
                if (text.isNotBlank() || text.isNotEmpty()) {
                    commentList.add(Comment(messageItemCounter,comment = text.toString(), user = "Rawlin"))
                    adapter.differ.submitList(commentList)
                }
            }
        }

        setupRecyclerView()

        setupTimer()

    }

    private fun setupTimer() {
        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timerText.text = "${millisUntilFinished / 1000}s"
            }

            override fun onFinish() {
                findNavController().navigate(R.id.action_gamePlayFragment_to_turnEndFragment)
            }
        }
        timer.start()
    }

    override fun onDestroyView() {
        timer.cancel()
        super.onDestroyView()
    }

    private fun setupRecyclerView() {
        adapter = MessagesAdapter()
        binding.apply {
            messageBoard.adapter = adapter
            messageBoard.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupCameraFragment() {
        val childFragment = CameraFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.camera_framgent_container, childFragment).commit()
    }
}