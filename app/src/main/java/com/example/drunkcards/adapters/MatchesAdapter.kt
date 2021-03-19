package com.example.drunkcards.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.drunkcards.R
import com.example.drunkcards.databinding.RvItemMatchBinding
import com.example.drunkcards.models.MatchesModel


class MatchesAdapter :RecyclerView.Adapter<MatchesAdapter.MatchesViewHolder>() {
    private var allMatches= mutableListOf<MatchesModel>()

    fun addDataToAdapter(matchesList :List<MatchesModel>){
        allMatches.addAll(matchesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchesAdapter.MatchesViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return MatchesViewHolder(RvItemMatchBinding.inflate(layoutInflater,parent,false))
    }

    override fun getItemCount(): Int {
        return allMatches.size
    }

    override fun onBindViewHolder(holder: MatchesAdapter.MatchesViewHolder, position: Int) {
        holder.bindData(allMatches[position])
    }


    inner class MatchesViewHolder(val binding:RvItemMatchBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(match:MatchesModel){
            Glide.with(binding.ivPlayer1Avatar)
                .load(R.drawable.ic_launcher_background)
                .into(binding.ivPlayer1Avatar)

            Glide.with(binding.ivPlayer2Avatar)
                .load(R.drawable.ic_launcher_background)
                .into(binding.ivPlayer2Avatar)
            binding.tvMatchId.text=match.matchId.toUpperCase()
            binding.tvPlayer1Name.text=match.userOneName
            binding.tvPlayer2Name.text=match.userTwoName
        }
    }
}