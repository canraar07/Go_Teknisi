package com.goteknisi.ui.dashboarcus

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goteknisi.R

class DashboarCusFragment : Fragment() {

    companion object {
        fun newInstance() = DashboarCusFragment()
    }

    private lateinit var viewModel: DashboarCusViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.dashboar_cus_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DashboarCusViewModel::class.java)
        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.constMainAct,DashboardNearby.newInstance())
                .commitNow()
        }
    }

}
