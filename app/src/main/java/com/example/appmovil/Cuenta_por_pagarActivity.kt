package com.example.appmovil

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Cuenta_por_pagarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuenta_por_pagar)


        findViewById<EditText>(R.id.textDatePagar).setOnClickListener(){
            showDatePikerDialog()
        }
        findViewById<EditText>(R.id.textDatePagarLimit).setOnClickListener(){
            showDatePikerDialogLimit()
        }

    }
    private fun showDatePikerDialog() {
        val datePicker=DatePickerFragment({day,month,year-> onDateSelected(year,month,day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }

    private fun onDateSelected(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.textDatePagar).setText("$day/$month/$year")
    }

    private fun showDatePikerDialogLimit() {
        val datePicker=DatePickerFragmentLimit({day,month,year-> onDateSelectedLimit(year,month,day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }

    private fun onDateSelectedLimit(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.textDatePagarLimit).setText("$day/$month/$year")
    }


    private fun jumpActivityLobby(){
        val intent: Intent = Intent(this,LobbyActivity::class.java)
        startActivity(intent)
    }
}