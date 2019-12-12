package com.goteknisi.ui.jeniskerusakan

import android.content.ClipData
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.goteknisi.ConfirmasiKerusakan
import com.goteknisi.R
import com.goteknisi.adapter.KerusakanAdapter
import com.goteknisi.utils.DataKerusakan
import com.goteknisi.utils.DatakerusakanCus
import kotlinx.android.synthetic.main.jenis_kerusakan_fragment.*

class JenisKerusakanFragment : Fragment() {

    companion object {
        fun newInstance(
            nama: String?,
            notlp: String?
        ) : JenisKerusakanFragment{
            val fragment = JenisKerusakanFragment()
            val bundle = Bundle().apply {
                putString("nama",nama)
                putString("notlp",notlp)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: JenisKerusakanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.jenis_kerusakan_fragment, container, false)
    }

    private lateinit var adapter: KerusakanAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(JenisKerusakanViewModel::class.java)
        val nama = arguments?.getString("nama")
        val notlp = arguments?.getString("notlp")
        adapter = KerusakanAdapter()
        adapter.dataClear()
        progressBar.isVisible=true
        list_kerusakan.isVisible=false
        bPriksa.isVisible=false
        bChat.isVisible=false
        viewModel.getKerusakanList()
        viewModel.getData().observe(this, Observer<ArrayList<DataKerusakan>> {data ->
            if(data != null){
                adapter.setData(data)
                progressBar.isVisible=false
                list_kerusakan.isVisible=true
                bPriksa.isVisible=true
                bChat.isVisible=true
            }
        })
        list_kerusakan.layoutManager = LinearLayoutManager(this.activity)
        list_kerusakan.adapter = adapter
        bPriksa.setOnClickListener {
            val kerusakan = adapter.getDataKerusakan()
            Log.e("Data",kerusakan.toString())
            val bundle = Bundle()
            val intent = Intent(this.context,ConfirmasiKerusakan::class.java)
            bundle.putParcelableArrayList("arrkerusakan",kerusakan)
            bundle.putString("nama",nama)
            bundle.putString("notlp",notlp)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}
