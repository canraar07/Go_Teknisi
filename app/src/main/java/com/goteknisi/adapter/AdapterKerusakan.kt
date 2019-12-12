package com.goteknisi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.goteknisi.R
import com.goteknisi.utils.DatakerusakanCus
import kotlinx.android.synthetic.main.template_list_kerusakan_confirm.view.*

class AdapterKerusakan : RecyclerView.Adapter<AdapterKerusakan.ListViewHolder>() {

    val list = ArrayList<DatakerusakanCus>()

    fun setData(items: ArrayList<DatakerusakanCus>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun dataClear() {
        list.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.template_list_kerusakan_confirm, viewGroup,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position],position)

    }

    override fun getItemCount(): Int = list.size


    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : DatakerusakanCus,position : Int){
            with(itemView){
                textKerusakan.text=data.kerusakan
            }
        }
    }

}