package com.thoriqramadhan.newsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thoriqramadhan.newsapp.DetailActivity
import com.thoriqramadhan.newsapp.data.ArticlesItem
import com.thoriqramadhan.newsapp.databinding.ItemNewsBinding

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    private var listNews = ArrayList<ArticlesItem>()

    fun setData(list: List<ArticlesItem>?){
        if (list == null)return
        listNews.clear()
        listNews.addAll(list)

    }
    inner class MyViewHolder( val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun getItemCount() = listNews.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listNews[position]
        holder.binding.apply{
            itemTitle.text = data.title
            itemDate.text = data.publishedAt
            Picasso.get().load(data.urlToImage).into(itemImage)
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA,data)
            it.context.startActivity(intent)
        }
    }
}