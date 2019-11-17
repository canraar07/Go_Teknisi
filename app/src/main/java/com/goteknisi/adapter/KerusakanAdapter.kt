package com.goteknisi.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goteknisi.R
import com.goteknisi.utils.DataKerusakan
import kotlinx.android.synthetic.main.template_list_kerusakan.view.*


class KerusakanAdapter : RecyclerView.Adapter<KerusakanAdapter.ListViewHolder>(){

    private val list = ArrayList<DataKerusakan>()

    fun setData(items: ArrayList<DataKerusakan>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun dataClear() {
        list.clear()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.template_list_kerusakan, viewGroup,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position],position)

    }

    override fun getItemCount(): Int = list.size

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : DataKerusakan,position : Int){
            with(itemView){
                var check : Int? = null
                textKerusakan.text = data.kerusakan
                textKerusakan.setOnCheckedChangeListener { buttonView, isChecked ->
                    Log.e("check",isChecked.toString())
                }
            }
        }
    }

}