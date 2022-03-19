package com.susan.githubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GitUserAdapter (private val listUser: ArrayList<GitUser>) : RecyclerView.Adapter<GitUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val ( username, name, avatar, repository) = listUser[position]
        holder.imgPhoto.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvUsername.text = username
        holder.tvCompany.text = repository
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_user)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvCompany: TextView = itemView.findViewById(R.id.tv_repo)

    }

    interface OnItemClickCallback{
        fun onItemClicked(data : GitUser)
    }
}