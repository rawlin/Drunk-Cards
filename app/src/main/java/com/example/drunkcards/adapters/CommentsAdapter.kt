package com.example.drunkcards.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.drunkcards.databinding.RvItemCommentBinding
import com.example.drunkcards.models.TaskComment


class CommentsAdapter :RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {
    private var taskComments= mutableListOf<TaskComment>()

    fun addDataToAdapter(commentsList :List<TaskComment>){
        taskComments.addAll(commentsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentsAdapter.CommentsViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return CommentsViewHolder(RvItemCommentBinding.inflate(layoutInflater,parent,false))
    }

    override fun getItemCount(): Int {
        return taskComments.size
    }

    override fun onBindViewHolder(holder: CommentsAdapter.CommentsViewHolder, position: Int) {
        holder.bindData(taskComments[position])
    }


    inner class CommentsViewHolder(val binding:RvItemCommentBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(comment:TaskComment){
            binding.tvUserNameAndComment.text=Html.fromHtml("<br>"+comment.commentedBy+"</br> "+comment.commentText)
            binding.tvPostDate.text=comment.commentedDate
        }
    }
}