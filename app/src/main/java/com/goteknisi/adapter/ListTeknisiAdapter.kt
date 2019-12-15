package com.goteknisi.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.goteknisi.OrderActivity
import com.goteknisi.ProfileTeknisiActivity
import com.goteknisi.R
import com.goteknisi.utils.DataConfirmPage
import com.goteknisi.utils.Datalis

class ListTeknisiAdapter:
    RecyclerView.Adapter<ListTeknisiAdapter.GridViewHolder>()  {

    private val list = ArrayList<Datalis>()
    private val dataKerusakan =  ArrayList<DataConfirmPage>()

    fun setData(items: ArrayList<Datalis>,data :  ArrayList<DataConfirmPage>) {
        list.clear()
        list.addAll(items)
        dataKerusakan.addAll(data)
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
            if(dataKerusakan.size > 0) {
                val dataOrder = ArrayList<DataConfirmPage>()
                dataOrder.add(
                    DataConfirmPage(
                        list[position].name,
                        dataKerusakan[0].namacus,
                        dataKerusakan[0].nocus,
                        dataKerusakan[0].tgl,
                        dataKerusakan[0].almt,
                        dataKerusakan[0].kerusakan,
                        list[position].kodemitra,
                        dataKerusakan[0].idcus
                    )
                )
                val bundle = Bundle()
                val intent = Intent(holder.itemView.context, OrderActivity::class.java)
                bundle.putParcelableArrayList("dataOrder", dataOrder)
                intent.putExtras(bundle)
                holder.itemView.context.startActivity(intent)
            }else{
                val bundle = Bundle()
                val intent = Intent(holder.itemView.context,ProfileTeknisiActivity::class.java)
                bundle.putString("kodemitra",list[position].kodemitra)
                intent.putExtras(bundle)
                holder.itemView.context.startActivity(intent)
            }
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