package com.goteknisi.ui.dashboarcus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.goteknisi.R
import com.goteknisi.adapter.DashboardListAdapter
import com.goteknisi.utils.Datalis
import kotlinx.android.synthetic.main.fragment_dashboard_list.*


class DashboardListFragment : Fragment() {

    private val arrayName = arrayOf("Jhono 1", "Jhono 2", "Jhono 4", "Jhono 2")
    private val arrayImg = intArrayOf(R.drawable.jhon, R.drawable.jhon, R.drawable.jhon, R.drawable.jhon)
    val lisdata = ArrayList<Datalis>()

    companion object {
        fun newInstance() = DashboardListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        creatDumy()
        recycleDashboard.layoutManager = GridLayoutManager(this.context, 2)
        val gridAdapter = DashboardListAdapter(lisdata)
        recycleDashboard.adapter = gridAdapter
    }

    fun creatDumy() {
        for (i in arrayName.indices) {
            lisdata.add(Datalis(arrayName[i], arrayImg[i]))
        }
    }
}
