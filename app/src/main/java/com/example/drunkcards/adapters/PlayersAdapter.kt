package com.example.drunkcards.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.drunkcards.databinding.RvItemPlayerBinding
import com.example.drunkcards.models.Players


class PlayersAdapter :RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {
    private var playersInRoom= mutableListOf<Players>()

    // todo use diff utils
    fun addDataToAdapter(playersList :List<Players>){
        playersInRoom.addAll(playersList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayersAdapter.PlayerViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return PlayerViewHolder(RvItemPlayerBinding.inflate(layoutInflater,parent,false))
    }

    override fun getItemCount(): Int {
        return playersInRoom.size
    }

    override fun onBindViewHolder(holder: PlayersAdapter.PlayerViewHolder, position: Int) {
        holder.bindData(playersInRoom[position])
    }


    inner class PlayerViewHolder(val binding:RvItemPlayerBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(player:Players){
            binding.tvName.text=player.name
            Glide.with(binding.root)
                .load(player.imageUrl)
                .centerCrop()
                .into(binding.ivPlayer)
           /* val paint=Paint()
            paint.color= Color.BLACK
            val bitmap =
                Bitmap.createBitmap(binding.ivPlayer.width, binding.ivPlayer.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            canvas.drawText(player.name.get(0)+"", binding.ivPlayer.width.toFloat()/2, binding.ivPlayer.height.toFloat()/2, paint)
            binding.ivPlayer.setImageBitmap(bitmap)*/

        }
    }
}