package com.aniketjain.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val items: ArrayList<String>, private val listener: NewsItemClicked) :
    RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        val viewHolder = NewsViewHolder(view)
        viewHolder.itemTitle.setOnClickListener { listener.onItemClicked(items[viewHolder.adapterPosition]) }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.itemTitle.text = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemTitle: TextView = itemView.findViewById(R.id.item_title)

}

interface NewsItemClicked {
    fun onItemClicked(item: String)
}