package com.goteknisi.ui.dashboardlistteknisi

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.goteknisi.R
import com.goteknisi.adapter.DashboardListAdapter
import com.goteknisi.adapter.ListTeknisiAdapter
import com.goteknisi.utils.DataKerusakan
import com.goteknisi.utils.Datalis
import kotlinx.android.synthetic.main.dashboard_list_teknisi_fragment.*
import kotlinx.android.synthetic.main.fragment_dashboard_list.*
import kotlinx.android.synthetic.main.jenis_kerusakan_fragment.*

class DashboardListTeknisiFragment : Fragment() {

    private val arrayName = arrayOf("Jhono 1", "Jhono 2", "Jhono 4", "Jhono 2")
    private val arrayImg = intArrayOf(R.drawable.jhon, R.drawable.jhon, R.drawable.jhon, R.drawable.jhon)
    val lisdata = ArrayList<Datalis>()

    companion object {
        fun newInstance() = DashboardListTeknisiFragment()
    }

    private lateinit var viewModel: DashboardListTeknisiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.dashboard_list_teknisi_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DashboardListTeknisiViewModel::class.java)
        recycleTeknisi.layoutManager = GridLayoutManager(this.context, 2)
        val gridAdapter = ListTeknisiAdapter()
        viewModel.getData().observe(this, Observer<ArrayList<Datalis>> { data ->
            if(data != null){
                gridAdapter.setData(data)
            }
        })
        recycleTeknisi.adapter = gridAdapter
    }

}
