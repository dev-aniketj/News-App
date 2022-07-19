package com.aniketjain.newsapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val listener: NewsItemClicked) :
    RecyclerView.Adapter<NewsViewHolder>() {

    private val items: ArrayList<NewsModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        val viewHolder = NewsViewHolder(view)
        viewHolder.itemTitle.setOnClickListener { listener.onItemClicked(items[viewHolder.adapterPosition]) }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.itemTitle.text = items[position].title
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateNews(updatedNewsItems: ArrayList<NewsModel>) {
        items.clear()
        items.addAll(updatedNewsItems)

        notifyDataSetChanged()
    }

}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemTitle: TextView = itemView.findViewById(R.id.item_title)

}

interface NewsItemClicked {
    fun onItemClicked(item: NewsModel)
}