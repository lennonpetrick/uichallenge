package com.test.uichallenge.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.uichallenge.Item
import com.test.uichallenge.R
import kotlinx.android.synthetic.main.layout_item_recycler_view.view.*

class ItemRecyclerAdapter(private val items: List<Item>)
    : RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPicture = view.imgItemPicture!!
        val tvTitle = view.tvItemTitle!!
        val tvDescription = view.tvItemDescription!!
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.ivPicture.setImageResource(item.picture!!)
        holder.tvTitle.text = item.title!!
        holder.tvDescription.text = item.description!!
    }
}