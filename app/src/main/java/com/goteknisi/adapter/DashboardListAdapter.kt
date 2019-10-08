package com.goteknisi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.goteknisi.R
import com.goteknisi.utils.Datalis

class DashboardListAdapter(val listValue: ArrayList<Datalis>) :
    RecyclerView.Adapter<DashboardListAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.template_grid_dashboard, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listValue[position].image)
            .into(holder.imgPhoto)
        holder.textview.text = listValue[position].name
    }

    override fun getItemCount(): Int {
        return listValue.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.imageView)
        var textview: TextView = itemView.findViewById(R.id.textView)
    }

}