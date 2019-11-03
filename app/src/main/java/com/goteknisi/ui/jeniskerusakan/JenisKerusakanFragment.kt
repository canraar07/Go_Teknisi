package com.goteknisi.ui.jeniskerusakan

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goteknisi.R

class JenisKerusakanFragment : Fragment() {

    companion object {
        fun newInstance() = JenisKerusakanFragment()
    }

    private lateinit var viewModel: JenisKerusakanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.jenis_kerusakan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(JenisKerusakanViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
