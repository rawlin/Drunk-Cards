package com.example.drunkcards

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.drunkcards.databinding.FragmentCardStackBinding
import com.example.drunkcards.mockData.MockData
import com.example.drunkcards.models.DareTask
import com.example.drunkcards.utils.TinderCard
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder


@SuppressLint("SetTextI18n")
class CardStackFragment : Fragment(R.layout.fragment_card_stack),TinderCard.Callback{
    private lateinit var binding: FragmentCardStackBinding
    private lateinit var cardSwipeView:SwipePlaceHolderView
    private lateinit var taskForThisUser:DareTask

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCardStackBinding.bind(view)
        binding.ivTask.visibility=View.INVISIBLE
        binding.tvTaskId.visibility=View.INVISIBLE
        cardSwipeView=binding.swipeView
        cardSwipeView.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
            .setDisplayViewCount(1)
            .setSwipeDecor(
                SwipeDecor()
                .setPaddingTop(20)
                .setRelativeScale(0.01f)
                .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in)
                .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out));
        val allTasks=MockData.getFakeTasks(60)
        // taking only one card out
        taskForThisUser=allTasks.subList(0,1)[0]
        cardSwipeView.addView(TinderCard(requireContext(),taskForThisUser,cardSwipeView,this))

        /*for(task:DareTask in allTasks){
            cardSwipeView.addView(TinderCard(requireContext(),task,cardSwipeView))
        }*/
    }

    override fun onCardSelected() {
        // show animation and start timer and show the task
        val oa1 = ObjectAnimator.ofFloat(binding.taskCard.cardView, "scaleX", 1f, 0f)
        val oa2 = ObjectAnimator.ofFloat(binding.taskCard.cardView, "scaleX", 0f, 1f)
        oa1.interpolator = DecelerateInterpolator()
        oa2.interpolator = AccelerateDecelerateInterpolator()
        oa1.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                //imageView.setImageResource(R.drawable.frontSide)
                binding.taskCard.tvTaskHead.text=taskForThisUser.title
                binding.taskCard.tvTaskDescription.text=taskForThisUser.description
                binding.taskCard.tvTimeRemaining.text=taskForThisUser.timeRemaining.toString()+" Seconds Remaining"
                binding.ivTask.visibility=View.VISIBLE
                binding.tvTaskId.visibility=View.VISIBLE
                startTimer()
                binding.taskCard.root.visibility=View.VISIBLE
                oa2.start()
            }
        })
        oa1.start()
    }

    private fun startTimer() {
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.taskCard.tvTimeRemaining.text= "${millisUntilFinished/1000} Seconds Remaining"
            }

            override fun onFinish() {
                binding.taskCard.tvTimeRemaining.text= "Time Up !"
                binding.btnStart.setBackgroundColor(R.color.grey)
                binding.btnStart.isEnabled=false
                binding.btnStart.text="Time Up"
            }
        }
        timer.start()
    }

}