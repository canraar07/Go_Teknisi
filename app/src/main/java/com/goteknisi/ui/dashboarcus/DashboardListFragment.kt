package com.goteknisi.ui.dashboarcus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.goteknisi.R
import com.goteknisi.adapter.DashboardListAdapter
import com.goteknisi.utils.DataItem
import com.goteknisi.utils.Datalis
import kotlinx.android.synthetic.main.dashboard_list_teknisi_fragment.*
import kotlinx.android.synthetic.main.fragment_dashboard_list.*


class DashboardListFragment : Fragment() {

    private val arrayName = arrayOf("Ketahui Kerusakan Mu", "Lihat Teknisi")
    private val arrayImg = intArrayOf(R.drawable.question, R.drawable.technician)
    val lisdata = ArrayList<DataItem>()
    var nama = ""
    var notlp = ""

    companion object {
        fun newInstance(
            nama: String?,
            notlp: String?
        ) : DashboardListFragment{
            val fragment = DashboardListFragment()
            val bundle = Bundle().apply {
                putString("nama",nama)
                putString("notlp",notlp)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        nama = arguments?.getString("nama").toString()
        notlp = arguments?.getString("notlp").toString()
        creatDumy()
        recyleMenu.layoutManager = GridLayoutManager(this.context, 2)
        val gridAdapter = DashboardListAdapter(lisdata)
        recyleMenu.adapter = gridAdapter
    }

    fun creatDumy() {
        for (i in arrayName.indices) {
            lisdata.add(DataItem(arrayName[i], arrayImg[i],nama,notlp))
        }
    }

}
