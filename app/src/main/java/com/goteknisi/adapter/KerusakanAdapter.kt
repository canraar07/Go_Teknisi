package com.goteknisi.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.goteknisi.R
import com.goteknisi.utils.DataKerusakan
import com.goteknisi.utils.DatakerusakanCus
import kotlinx.android.synthetic.main.template_list_kerusakan.view.*


class KerusakanAdapter : RecyclerView.Adapter<KerusakanAdapter.ListViewHolder>(){

    private val list = ArrayList<DataKerusakan>()
    val kerusakan = ArrayList<DatakerusakanCus>()

    fun setData(items: ArrayList<DataKerusakan>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun dataClear() {
        list.clear()
        notifyDataSetChanged()
    }

    fun getDataKerusakan() : ArrayList<DatakerusakanCus>{
        return kerusakan
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.template_list_kerusakan, viewGroup,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position],position)
        holder.itemView.textKerusakan.setOnCheckedChangeListener { buttonView, isChecked ->
            kerusakan.add(DatakerusakanCus(list[position].kerusakan,list[position].type))
        }

    }

    override fun getItemCount(): Int = list.size

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {



        fun bind(data : DataKerusakan,position : Int){
            with(itemView){
                textKerusakan.text = data.kerusakan
            }
        }
    }

}