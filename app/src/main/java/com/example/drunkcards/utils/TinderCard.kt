package com.example.drunkcards.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import com.example.drunkcards.R
import com.example.drunkcards.models.DareTask
import com.mindorks.placeholderview.SwipeDirection
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Position
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.*
import timber.log.Timber


@Layout(R.layout.card_item)
class TinderCard(private val context: Context,
                 private val todoTask: DareTask,
                 private val swipePlaceHolderView: SwipePlaceHolderView,
                 private val cardCallBack:TinderCard.Callback
                ) {

    @View(R.id.tv_task_description)
    lateinit var tv_task_description: TextView

    @View(R.id.tv_time_remaining)
    lateinit var tv_time_remaining: TextView

    @View(R.id.tv_task_head)
    lateinit var tv_task_title: TextView

    init {
        Timber.d("Timber card created")
    }

    @JvmField
    @Position
    var position: Int = 0;

    @SuppressLint("SetTextI18n")
    @Resolve
    fun onResolved() {
        tv_task_description.text=todoTask.description
        if(todoTask.timeRemaining==-1){
            tv_time_remaining.text=""
        }else
            tv_time_remaining.text=todoTask.timeRemaining.toString()+" Seconds Remaining"
        tv_task_title.text=todoTask.title
    }

    @SwipeOutDirectional
    fun onSwipeOutDirectional(direction: SwipeDirection) {
        Timber.d("SwipeOutDirectional %s", direction.name)
        if (direction.direction == SwipeDirection.TOP.direction) {
//            callback.onSwipeUp()
        }
    }

    @SwipeCancelState
    fun onSwipeCancelState() {
        Timber.d("onSwipeCancelState")
        swipePlaceHolderView.alpha = 1f
    }

    @SwipeOut
    fun onSwipedOut() {
        Timber.d("onSwipedOut")
        cardCallBack.onCardSelected()
    }

    @SwipeIn
    fun OnSwipeIn(){
        Timber.d("onSwipedIn")
        cardCallBack.onCardSelected()
    }

    @SwipeOutState
    fun onSwipeOutState() {
        Timber.d("onSwipeOutState")
    }

    @SwipeInDirectional
    fun onSwipeInDirectional(direction: SwipeDirection) {
        Timber.d("SwipeInDirectional %s", direction.name)
    }

    @SwipingDirection
    fun onSwipingDirection(direction: SwipeDirection) {
        Timber.d("SwipingDirection %s", direction.name)
    }

    @SwipeTouch
    fun onSwipeTouch(xStart: Float, yStart: Float, xCurrent: Float, yCurrent: Float) {

        /*val cardHolderDiagonalLength =
            sqrt(Math.pow(cardViewHolderSize.x.toDouble(), 2.0)
                    + (Math.pow(cardViewHolderSize.y.toDouble(), 2.0)))
        val distance = sqrt(Math.pow(xCurrent.toDouble() - xStart.toDouble(), 2.0)
                + (Math.pow(yCurrent.toDouble() - yStart, 2.0)))

        val alpha = 1 - distance / cardHolderDiagonalLength

        Log.d("DEBUG", "onSwipeTouch "
                + " xStart : " + xStart
                + " yStart : " + yStart
                + " xCurrent : " + xCurrent
                + " yCurrent : " + yCurrent
                + " distance : " + distance
                + " TotalLength : " + cardHolderDiagonalLength
                + " alpha : " + alpha
        )*/

        //swipeView.alpha = alpha.toFloat();
    }

    interface Callback {
        fun onCardSelected()
    }
}