package com.dicoding.newsapp.core.ui.adapter.adapterhome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.newsapp.core.R
import com.dicoding.newsapp.core.databinding.ItemCategoryListBinding
import com.dicoding.newsapp.core.domain.model.Science
import java.util.*

class ScienceCategoryAdapter: RecyclerView.Adapter<ScienceCategoryAdapter.ListViewHolder>()  {
    private var listData = ArrayList<Science>()
    var onItemClick: ((Science) -> Unit)? = null

    fun setData(newListData: List<Science>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCategoryListBinding.bind(itemView)
        fun bind(data: Science) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.urlToImage)
                    .into(imageNewsCategory)
                titleNewsCategory.text = data.title
                authorNewsCategory.text = data.author
                publishedAtCategory.text = data.publishedAt
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}