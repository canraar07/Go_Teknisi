package com.goteknisi.ui.order

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

}
