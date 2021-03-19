package com.example.drunkcards.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.drunkcards.R
import com.example.drunkcards.models.DareTask

class CardStackAdapter(
        private var spots: List<DareTask> = emptyList()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.card_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spot = spots[position]
        holder.title.text = spot.title
        holder.timeRemaining.text = spot.timeRemaining.toString()+""
        holder.description.text=spot.description
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun setSpots(spots: List<DareTask>) {
        this.spots = spots
    }

    fun getSpots(): List<DareTask> {
        return spots
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_task_head)
        var description: TextView = view.findViewById(R.id.tv_task_description)
        var timeRemaining: TextView = view.findViewById(R.id.tv_time_remaining)
    }

}
