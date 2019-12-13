package com.goteknisi.ui.order

import android.app.AlertDialog
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.goteknisi.R
import com.goteknisi.utils.DataConfirmPage
import kotlinx.android.synthetic.main.order_fragment.*

class OrderFragment : Fragment() {

    companion object {
        fun newInstance(
            dataOrder: ArrayList<DataConfirmPage>
        ) : OrderFragment{
            val fragment = OrderFragment()
            val bundle = Bundle().apply {
                putParcelableArrayList("dataOrder",dataOrder)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.order_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OrderViewModel::class.java)
        val dataOrder : java.util.ArrayList<DataConfirmPage>? = arguments?.getParcelableArrayList("dataOrder")
        namateknisi.text = "Nama Teknisi Kamu : ${dataOrder!![0].namateknisi}"
        namacus.text = "Nama Kamu : ${dataOrder!![0].namacus}"
        tanggalperbaikan.text = "Tanggal Booking Perbaikan : ${dataOrder!![0].tgl}"
        alamat.text = "Alamat Kamu : ${dataOrder!![0].almt}"
        notlpcus.text = "Nomor Telpone Kamu : ${dataOrder!![0].nocus}"
        progressBar4.isVisible=false
        buttonOrder.setOnClickListener {
            progressBar4.isVisible=true
            viewModel.Order(dataOrder)
            viewModel.getStatus().observe(this, Observer<ArrayList<String>> {data ->
                progressBar4.isVisible=false
                if(data[0] == "sukses"){
                    val alertDialog = AlertDialog.Builder(context)
                    alertDialog.setTitle("Kamu Berhasil Order")
                    alertDialog.setMessage("Ini Adalah No Order Kamu ${data[1]}")
                    alertDialog.setPositiveButton("Ok"){dialog, which ->
                        dialog.dismiss()
                    }

                    alertDialog.setNegativeButton("No"){dialog,which ->
                        dialog.dismiss()
                    }
                    val dialog: AlertDialog = alertDialog.create()
                    dialog.show()
                }else{
                    Toast.makeText(this.context,"Gagal",Toast.LENGTH_LONG)
                        .show()
                }
            })
        }
    }

}
