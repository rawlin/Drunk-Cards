package com.example.drunkcards.utils;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.drunkcards.R;
import com.example.drunkcards.models.DareTask;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;


@Layout(R.layout.card_item)
public class TinderCardJava {

    @View(R.id.tv_task_head)
    public TextView tv_heading;

    @View(R.id.tv_task_description)
    public TextView tv_description;

    @View(R.id.tv_time_remaining)
    public TextView tv_time_remaining;

    public DareTask dareTask;
    public Context mContext;
    public SwipePlaceHolderView mSwipeView;

    public TinderCardJava(Context context, DareTask dareTask, SwipePlaceHolderView swipeView) {
        mContext = context;
        this.dareTask = dareTask;
        mSwipeView = swipeView;
    }

    @Resolve
    public void onResolved(){
        tv_heading.setText(dareTask.getTitle());
        tv_description.setText(dareTask.getDescription());

    }

    @SwipeOut
    public void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    public void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    public void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    public void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    public void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }
}
