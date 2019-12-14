package com.goteknisi.ui.dashboarcus

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
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
                                       // mygmap?.moveCamera(CameraUpdateFactory.newLatLng(lng))
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
