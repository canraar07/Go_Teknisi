package com.goteknisi.ui.regis

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goteknisi.R

class RegisFragment : Fragment() {

    companion object {
        fun newInstance() = RegisFragment()
    }

    private lateinit var viewModel: RegisViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.regis_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
