package com.goteknisi.ui.teknisidetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goteknisi.R

class TeknisiDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TeknisiDetailFragment()
    }

    private lateinit var viewModel: TeknisiDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.teknisi_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TeknisiDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
