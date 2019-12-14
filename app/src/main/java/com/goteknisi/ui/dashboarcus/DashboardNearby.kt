package com.goteknisi.ui.dashboarcus

import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.goteknisi.R
import com.goteknisi.network.ApiendPoint
import com.goteknisi.network.BaseApi
import com.goteknisi.network.response.ResponseMaps
import retrofit2.Call
import retrofit2.Response


class DashboardNearby : Fragment(), OnMapReadyCallback {

    lateinit var mygmap: GoogleMap
    private var locationManager : LocationManager? = null


    companion object {
        var mapFragment: SupportMapFragment? = null
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
        this.context?.let {
            getListMap(it)
        }
        val location = LatLng(-6.1800122, 106.8398761)
        val cameraPosition = CameraPosition.Builder()
            .target(location)
            .zoom(15F)
            .build()
        mygmap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

    fun getListMap(context : Context){
        BaseApi.creatService(ApiendPoint::class.java)
            .getListMap()
            .enqueue(object : retrofit2.Callback<ResponseMaps>{
                override fun onFailure(call: Call<ResponseMaps>, t: Throwable) {
                    Toast.makeText(context,"gagal",Toast.LENGTH_LONG)
                        .show()
                }

                override fun onResponse(
                    call: Call<ResponseMaps>,
                    response: Response<ResponseMaps>
                ) {
                    response.let {
                        if(response.isSuccessful){
                            it.body().let {
                                val status = it!!.status
                                if(status == "sukses"){
                                    val res = it.result
                                    for(i in res.indices){
                                        val lng = LatLng(res[i].lat!!.toDouble(), res[i].lang!!.toDouble())
                                        mygmap.addMarker(MarkerOptions().position(lng)
                                            .title(res[i].nama_toko))
                                    }
                                }else{
                                    Toast.makeText(context,"gagal",Toast.LENGTH_LONG)
                                        .show()
                                }
                            }
                        }else{
                            Toast.makeText(context,"gagal",Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }

            })
    }

}
