package com.example.drunkcards

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.drunkcards.adapters.HumanityCardsAdapter
import com.example.drunkcards.databinding.FragmentPublicGameGraderBinding
import com.example.drunkcards.databinding.FragmentPublicGameParticipantBinding
import com.example.drunkcards.mockData.MockData
import com.example.drunkcards.models.CardsOFHumanity

class PublicGameGraderFragment:Fragment(R.layout.fragment_public_game_grader) {

    //todo he would get only one options
    private lateinit var binding:FragmentPublicGameGraderBinding
    private lateinit var allQuestions:List<CardsOFHumanity>
    private var currentQuestionIndex=-1
    private lateinit var currentQuestion:CardsOFHumanity
    private lateinit var optionsAdapter:HumanityCardsAdapter
    private lateinit var timer: CountDownTimer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPublicGameGraderBinding.bind(view)

        allQuestions=MockData.getCardsOfHumanity()
        setDataInUI()

        startTimer()
    }

    private fun startTimer() {
        timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text= "${millisUntilFinished/1000} Seconds"
            }

            override fun onFinish() {
                findNavController().navigateUp()
            }
        }
        timer.start()
    }

    private fun setDataInUI() {
        currentQuestionIndex++
        currentQuestion=allQuestions[currentQuestionIndex]
        optionsAdapter= HumanityCardsAdapter{
            currentQuestion.userSelectedOption=it
        }

        binding.rvOptions.adapter=optionsAdapter
        binding.tvTaskHead.text="Question "+(currentQuestionIndex+1)
        binding.tvTaskDescription.text=currentQuestion.question
        optionsAdapter.addDataToAdapter(currentQuestion.options)
    }

    override fun onDestroyView() {
        timer.cancel()
        super.onDestroyView()
    }
}