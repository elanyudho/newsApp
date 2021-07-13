package com.dicoding.newsapp.core.ui.adapter.adapterbookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.newsapp.core.R
import com.dicoding.newsapp.core.databinding.ItemHeadlineListBinding

import com.dicoding.newsapp.core.domain.model.Entertainment

import java.util.ArrayList

class EntertainmentAdapter: RecyclerView.Adapter<EntertainmentAdapter.ListViewHolder>() {

    private var listData = ArrayList<Entertainment>()
    var onItemClick: ((Entertainment) -> Unit)? = null

    fun setData(newListData: List<Entertainment>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemHeadlineListBinding.bind(itemView)
        fun bind(data: Entertainment){
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.urlToImage)
                    .into(imageNewsHeadline)
                titleNews.text = data.title
                authorNews.text = data.author
                publishedAt.text = data.publishedAt
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_headline_list, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}