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
import com.goteknisi.utils.DataConfirmPage
import com.goteknisi.utils.DataKerusakan
import com.goteknisi.utils.Datalis
import kotlinx.android.synthetic.main.dashboard_list_teknisi_fragment.*
import kotlinx.android.synthetic.main.fragment_dashboard_list.*
import kotlinx.android.synthetic.main.jenis_kerusakan_fragment.*

class DashboardListTeknisiFragment : Fragment() {

    companion object {
        fun newInstance(
            confirmKerusakan: ArrayList<DataConfirmPage>
        ) : DashboardListTeknisiFragment{
            val fragment = DashboardListTeknisiFragment()
            val bundle = Bundle().apply {
                putParcelableArrayList("confirmKerusakan",confirmKerusakan)
            }
            fragment.arguments = bundle
            return fragment
        }
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
        val dataconfirm : java.util.ArrayList<DataConfirmPage>? = arguments?.getParcelableArrayList("confirmKerusakan")
        recycleTeknisi.layoutManager = GridLayoutManager(this.context, 2)
        val gridAdapter = ListTeknisiAdapter()
        progresLoading.isVisible = true
        viewModel.getListMitra()
        viewModel.getData().observe(this, Observer<ArrayList<Datalis>> { data ->
            if(data != null){
                gridAdapter.dataClear()
                gridAdapter.setData(data)
                progresLoading.isVisible = false
            }
        })
        recycleTeknisi.adapter = gridAdapter
    }

}
