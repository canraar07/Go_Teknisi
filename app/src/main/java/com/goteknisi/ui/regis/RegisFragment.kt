package com.goteknisi.ui.regis

import android.app.AlertDialog
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.goteknisi.MainActivity
import com.goteknisi.R
import kotlinx.android.synthetic.main.regis_fragment.*

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
        progressBar3.isVisible=false
        val context = this.context
        bSubmit.setOnClickListener {
            progressBar3.isVisible=true
            val name = textregisname.text
            val usr = textregisemail.text
            val pswd = textregispassword.text
            val phone = textregisphone.text
            val almt = textregisaddres.text
            viewModel.Regis(usr.toString(),pswd.toString(),almt.toString(),name.toString(),phone.toString(),context)
            viewModel.getStatus().observe(this, Observer<String>{status ->
                if(status == "sukses"){
                progressBar3.isVisible=false
                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle("Kamu Berhasil Registrasi")
                alertDialog.setMessage("Klik Tombol Ok Untuk Menuju Halaman Login")
                alertDialog.setPositiveButton("Ok"){dialog, which ->
                    val intent = Intent(context,MainActivity::class.java)
                    context!!.startActivity(intent)
                }

                alertDialog.setNegativeButton("No"){dialog,which ->
                    textregisname.setText("")
                    textregisemail.setText("")
                    textregispassword.setText("")
                    textregisphone.setText("")
                    textregisaddres.setText("")
                }

                val dialog: AlertDialog = alertDialog.create()
                dialog.show()
                }
            })
        }
    }

}
