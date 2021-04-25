package com.suret.livescore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suret.livescore.R
import com.suret.livescore.model.InterestModel

class InterestRecyclerAdapter(private val interestList: MutableList<InterestModel>) :
    RecyclerView.Adapter<InterestRecyclerAdapter.InterestViewHolder>() {

    inner class InterestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.interest_icon)
        val title: TextView = itemView.findViewById(R.id.interest_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return InterestViewHolder(layoutInflater.inflate(R.layout.interest_layout, parent, false))
    }

    override fun onBindViewHolder(holder: InterestViewHolder, position: Int) {
        holder.icon.setImageResource(interestList[position].icon)
        holder.title.text = (holder.itemView.resources.getString(interestList[position].title))
    }

    override fun getItemCount(): Int = interestList.size
}