package com.goteknisi.ui.confirmasikerusakan

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.goteknisi.DashboardListTeknisiActivity
import com.goteknisi.R
import kotlinx.android.synthetic.main.confirmasi_kerusakan_fragment.*
import java.text.SimpleDateFormat
import java.util.*

class ConfirmasiKerusakanFragment : Fragment() {

    companion object {
        fun newInstance() = ConfirmasiKerusakanFragment()
    }

    private lateinit var viewModel: ConfirmasiKerusakanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.confirmasi_kerusakan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ConfirmasiKerusakanViewModel::class.java)
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
            val intent = Intent(this.context,DashboardListTeknisiActivity::class.java)
            startActivity(intent)
        }
    }

}
