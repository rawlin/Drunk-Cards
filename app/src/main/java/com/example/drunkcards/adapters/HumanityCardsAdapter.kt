package com.example.drunkcards.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.drunkcards.R
import com.example.drunkcards.databinding.RvItemCardOptionBinding


class HumanityCardsAdapter(val optionClickedCallback: (option:Int)-> Unit) :RecyclerView.Adapter<HumanityCardsAdapter.OptionsViewHolder>() {
    private var allMatches= mutableListOf<String>()

    fun addDataToAdapter(matchesList :List<String>){
        allMatches.addAll(matchesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HumanityCardsAdapter.OptionsViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return OptionsViewHolder(RvItemCardOptionBinding.inflate(layoutInflater,parent,false))
    }

    override fun getItemCount(): Int {
        return allMatches.size
    }

    override fun onBindViewHolder(holder: HumanityCardsAdapter.OptionsViewHolder, position: Int) {
        holder.bindData(allMatches[position])
    }

    inner class OptionsViewHolder(val binding:RvItemCardOptionBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(option:String){
            binding.tvOption.text=option

            binding.root.setOnClickListener {
                //todo add yellow border when selected and add data to the model
                binding.cardView.setBackgroundResource(R.drawable.selected_card_bg)
                optionClickedCallback(adapterPosition)
            }
        }
    }
}