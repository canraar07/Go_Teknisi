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
        fun newInstance(
            nama: String?,
            notlp: String?
        ) : DashboarCusFragment{
            val fragment = DashboarCusFragment()
            val bundle = Bundle().apply {
                putString("nama",nama)
                putString("notlp",notlp)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: DashboarCusViewModel
    var nama = ""
    var notlp = ""

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_Home -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.constMainAct, DashboardListFragment.newInstance(
                            nama,
                            notlp
                        ))
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
        nama = arguments?.getString("nama").toString()
        notlp = arguments?.getString("notlp").toString()
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.constMainAct, DashboardListFragment.newInstance(
                    nama,
                    notlp
                ))
                .commitNow()
        }
    }

}
