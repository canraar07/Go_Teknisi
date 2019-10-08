package com.goteknisi.ui.dashboarcus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.goteknisi.R


class DashboardNearby : Fragment(),OnMapReadyCallback {

    lateinit var mygmap : GoogleMap
    companion object {
        var mapFragment : SupportMapFragment?=null
        fun newInstance() = DashboardNearby()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_dashboard_nearby, container, false)
        mapFragment = childFragmentManager?.findFragmentById(R.id.mapView) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
        return rootView
    }


    override fun onMapReady(googleMap: GoogleMap?) {
        if (googleMap != null) {
            mygmap = googleMap
        }
       mygmap?.uiSettings?.isMyLocationButtonEnabled = true
       mygmap?.isMyLocationEnabled = true
       val lng = LatLng(40.7143528, -74.0059731)
       mygmap?.moveCamera(CameraUpdateFactory.newLatLng(lng))
    }

}
