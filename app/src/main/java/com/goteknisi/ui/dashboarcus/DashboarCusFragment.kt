package com.goteknisi.ui.dashboarcus

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.goteknisi.R
import kotlinx.android.synthetic.main.dashboar_cus_fragment.*

class DashboarCusFragment : Fragment() {

    companion object {
        fun newInstance() = DashboarCusFragment()
    }

    private lateinit var viewModel: DashboarCusViewModel

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_Home -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.constMainAct, DashboardListFragment.newInstance())
                        .commitNow()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_nearby -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.constMainAct, DashboardNearby.newInstance())
                        .commitNow()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {

                }
            }
            false
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.dashboar_cus_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DashboarCusViewModel::class.java)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.constMainAct, DashboardListFragment.newInstance())
                .commitNow()
        }
    }

}
