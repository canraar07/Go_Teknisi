package com.goteknisi.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.goteknisi.DetailStatusOrderActiviy
import com.goteknisi.R
import com.goteknisi.utils.DataDetailStatusOrder
import com.goteknisi.utils.DataStatusOrder
import com.goteknisi.utils.DatakerusakanCus
import kotlinx.android.synthetic.main.template_order_status.view.*

class AdapterStatusOrder : RecyclerView.Adapter<AdapterStatusOrder.ListViewHolder>() {

    val list = ArrayList<DataStatusOrder>()

    fun setData(items: ArrayList<DataStatusOrder>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun dataClear() {
        list.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.template_order_status, viewGroup,false)
        return AdapterStatusOrder.ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterStatusOrder.ListViewHolder, position: Int) {
        holder.bind(list[position],position)

    }

    override fun getItemCount(): Int = list.size

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : DataStatusOrder, position : Int){
            with(itemView){
                text_idorder.text = data.invoice
                text_status.text = data.statusorder
                itemView.setOnClickListener {
                    val detailstatus = ArrayList<DataDetailStatusOrder>()
                    detailstatus.add(
                        DataDetailStatusOrder(
                        data.namatek,data.namacus,data.invoice,data.tglperbaikan,data.alamatcus
                    ,data.jeniskerusakan,data.codeteknisi,data.idcustomer,data.nocus,data.statusorder
                    )
                    )
                    val bundle = Bundle()
                    val intent = Intent(itemView.context,DetailStatusOrderActiviy::class.java)
                    bundle.putParcelableArrayList("datastorder",detailstatus)
                    intent.putExtras(bundle)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}