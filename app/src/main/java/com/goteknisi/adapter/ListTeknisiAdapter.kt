package com.goteknisi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.goteknisi.R
import com.goteknisi.utils.Datalis

class ListTeknisiAdapter:
    RecyclerView.Adapter<ListTeknisiAdapter.GridViewHolder>()  {

    private val list = ArrayList<Datalis>()

    fun setData(items: ArrayList<Datalis>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun dataClear() {
        list.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.template_grid_dashboard, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(list[position].image)
            .into(holder.imgPhoto)
        holder.textview.text = list[position].name
        holder.cardMenu.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.imageView)
        var textview: TextView = itemView.findViewById(R.id.textView)
        var cardMenu: CardView = itemView.findViewById(R.id.cardContentTeknisi)
    }
}