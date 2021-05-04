package com.suret.livescore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.suret.livescore.R
import com.suret.livescore.model.NewsModel

class NewsRecyclerAdapter(private val newsList: List<NewsModel>) :
    RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val news_thumbnail: ImageView = itemView.findViewById(R.id.news_thumbnail)
        val news_title: TextView = itemView.findViewById(R.id.news_title_TV)
        val news_date: TextView = itemView.findViewById(R.id.news_date_TV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_list_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.news_thumbnail.load(newsList[position].news_thumbnail)
        holder.news_title.text = newsList[position].news_title
        holder.news_date.text = newsList[position].news_date
    }

    override fun getItemCount(): Int = newsList.size


}