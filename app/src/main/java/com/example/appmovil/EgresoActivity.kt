package com.example.appmovil

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EgresoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egreso)


        findViewById<EditText>(R.id.textDateEgreso).setOnClickListener(){
            showDatePikerDialog()
        }

    }
    private fun showDatePikerDialog() {
        val datePicker=DatePickerFragment({day,month,year-> onDateSelected(year,month,day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }

    private fun onDateSelected(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.textDateEgreso).setText("$day/$month/$year")
    }
    private fun jumpActivityLobby(){
        val intent: Intent = Intent(this,LobbyActivity::class.java)
        startActivity(intent)
    }
}