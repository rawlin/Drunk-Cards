package com.example.drunkcards.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.drunkcards.R
import com.example.drunkcards.databinding.RvItemPlayerScoreBinding
import com.example.drunkcards.models.MatchResultForAPlayer

// todo use diff utils
class GameResultsAdapter :RecyclerView.Adapter<GameResultsAdapter.GameResultViewHolder>() {
    private var playersList= mutableListOf<MatchResultForAPlayer>()

    fun addDataToAdapter(commentsList :List<MatchResultForAPlayer>){
        playersList.addAll(commentsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GameResultsAdapter.GameResultViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return GameResultViewHolder(RvItemPlayerScoreBinding.inflate(layoutInflater,parent,false))
    }

    override fun getItemCount(): Int {
        return playersList.size
    }

    override fun onBindViewHolder(holder: GameResultsAdapter.GameResultViewHolder, position: Int) {
        holder.bindData(playersList[position])
    }

    inner class GameResultViewHolder(val binding:RvItemPlayerScoreBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(playerResult:MatchResultForAPlayer){
            //todo create avatars for users with their initials
            Glide.with(binding.ivPlayerAvatar)
                .load(R.drawable.ic_launcher_background)
                .into(binding.ivPlayerAvatar)
            binding.tvPlayerName.text=playerResult.username
            binding.tvPlayerPoints.text=playerResult.userPoints.toString()
        }
    }
}