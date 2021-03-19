package com.example.drunkcards

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.drunkcards.adapters.HumanityCardsAdapter
import com.example.drunkcards.databinding.FragmentPublicGameParticipantBinding
import com.example.drunkcards.mockData.MockData
import com.example.drunkcards.models.CardsOFHumanity

class PublicGameParticipantsFragment:Fragment(R.layout.fragment_public_game_participant) {

    private lateinit var binding: FragmentPublicGameParticipantBinding
    private lateinit var allQuestions:List<CardsOFHumanity>
    private var currentQuestionIndex=-1
    private lateinit var currentQuestion: CardsOFHumanity
    private lateinit var optionsAdapter: HumanityCardsAdapter
    private var currentTimeCountDown=0
    private lateinit var timer:CountDownTimer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPublicGameParticipantBinding.bind(view)

        allQuestions=MockData.getCardsOfHumanity()
        setDataInUI()
    }

    private fun setDataInUI() {
        currentQuestionIndex++
        if(currentQuestionIndex==allQuestions.size)
            return
        currentQuestion=allQuestions[currentQuestionIndex]
        optionsAdapter= HumanityCardsAdapter{
            currentQuestion.userSelectedOption=it
        }
        startTimer()
        binding.rvOptions.adapter=optionsAdapter
        optionsAdapter.addDataToAdapter(currentQuestion.options)
    }

    private fun startTimer() {
        timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text= "${millisUntilFinished/1000} Seconds"
            }

            override fun onFinish() {
                findNavController().navigate(R.id.action_publicGameParticipantsFragment_to_publicGameGraderFragment)
            }
        }
        timer.start()
    }


    override fun onDestroyView() {
        timer.cancel()
        super.onDestroyView()
    }
}