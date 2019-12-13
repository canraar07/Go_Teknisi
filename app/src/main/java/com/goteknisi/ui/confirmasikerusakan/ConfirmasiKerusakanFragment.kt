package com.goteknisi.ui.confirmasikerusakan

import android.app.TimePickerDialog
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.goteknisi.DashboardListTeknisiActivity
import com.goteknisi.R
import com.goteknisi.adapter.AdapterKerusakan
import com.goteknisi.utils.DataConfirmPage
import com.goteknisi.utils.DatakerusakanCus
import kotlinx.android.synthetic.main.confirmasi_kerusakan_fragment.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ConfirmasiKerusakanFragment : Fragment() {

    companion object {
        fun newInstance(
            array: ArrayList<DatakerusakanCus>,
            nama : String?,
            notlp : String?,
            idcus : String?
            ) : ConfirmasiKerusakanFragment{
            val fragment = ConfirmasiKerusakanFragment()
            val bundle = Bundle().apply {
                putParcelableArrayList("arrkerusakan",array)
                putString("nama",nama)
                putString("notlp",notlp)
                putString("idcus",idcus)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: ConfirmasiKerusakanViewModel
    private lateinit var adapter: AdapterKerusakan
    var confirmdata = ArrayList<DataConfirmPage>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.confirmasi_kerusakan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ConfirmasiKerusakanViewModel::class.java)
        val arrkerusakan : java.util.ArrayList<DatakerusakanCus>? = arguments?.getParcelableArrayList("arrkerusakan")
        val nama = arguments?.getString("nama")
        val notlp = arguments?.getString("notlp")
        val idcus = arguments?.getString("idcus")
        recylekkerusakan.layoutManager = LinearLayoutManager(this.activity)
        adapter = AdapterKerusakan()
        adapter.dataClear()
        arrkerusakan?.let { adapter.setData(it) }
        recylekkerusakan.adapter = adapter
        calendarView.minDate=Date().time
        calendarView.isVisible=false
        containtTime.setOnClickListener {
            val mcurentTime = Calendar.getInstance()
            val hour = mcurentTime.get(Calendar.HOUR_OF_DAY)
            val minuts = mcurentTime.get(Calendar.MINUTE)
            val mTimePicker : TimePickerDialog
            mTimePicker = TimePickerDialog(this.context,
                TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                    Log.e("hour",selectedHour.toString())
                    textTime.text = "$selectedHour : $selectedMinute"
                },
            hour,
            minuts,
            true
        )
            mTimePicker.setTitle("select Time")
            mTimePicker.show()
        }
        containtTgl.setOnClickListener {
            calendarView.isVisible=true
        }
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            textViewTgl.text = "$dayOfMonth:$month:$year"
            calendarView.isVisible=false
        }
        buttonPteknisi.setOnClickListener {
            val text_tgl = textViewTgl.text
            val text_jam = textTime.text
            val text_alamat = editTextAlamat.text.toString()
            if(text_tgl.isNullOrEmpty()){
                Toast.makeText(this.context,"Tanggal tidak boleh kosong",Toast.LENGTH_LONG)
                    .show()
            }else if(text_jam.isNullOrEmpty()){
                Toast.makeText(this.context,"Jam tidak boleh kosong",Toast.LENGTH_LONG)
                    .show()
            }else if(text_alamat.isNullOrEmpty()){
                Toast.makeText(this.context,"Alamat tidak boleh kosong",Toast.LENGTH_LONG)
                    .show()
            }else{
            val tgl = "${textTime.text} / ${textViewTgl.text}"
            val almt = editTextAlamat.text.toString()
            confirmdata.add(
                DataConfirmPage("",nama,notlp,tgl,almt,arrkerusakan,"",idcus)
            )
            val bundle = Bundle()
            val intent = Intent(this.context,DashboardListTeknisiActivity::class.java)
            bundle.putParcelableArrayList("datakerusakan",confirmdata)
            intent.putExtras(bundle)
            startActivity(intent)
            }
        }
    }

}
