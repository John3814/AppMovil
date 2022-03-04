package com.example.appmovil

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IngresoActivity: AppCompatActivity()  {
    var txtFecha:EditText?=null
    var txtConcepto:EditText?=null
    var txtValor:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        txtFecha=findViewById(R.id.textDateIngreso)
        txtConcepto=findViewById(R.id.txtConcepto)
        txtValor=findViewById(R.id.txtValor)

        findViewById<EditText>(R.id.textDateIngreso).setOnClickListener(){
            showDatePikerDialog()
        }

    }
    private fun showDatePikerDialog() {
        val datePicker=DatePickerFragment({day,month,year-> onDateSelected(year,month,day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }

    private fun onDateSelected(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.textDateIngreso).setText("$day/$month/$year")
    }

    fun insertar(view:View){
        var con=SQLite(this,"basemovil",null,1)
        var baseDatos=con.writableDatabase

        var fecha=txtFecha?.text.toString()
        var concepto=txtConcepto?.text.toString()
        var valor=txtValor?.text.toString()

        if(fecha.isEmpty()==false && concepto.isEmpty()==false && valor.isEmpty()==false){
            var registro=ContentValues()

            registro.put("concept",concepto)
            registro.put("value",valor)
            registro.put("date",fecha)
            baseDatos.insert("Ingresos",null,registro)
            txtFecha?.setText("")
            txtConcepto?.setText("")
            txtValor?.setText("")
            Toast.makeText(this, "el ingreso se ha guardado", Toast.LENGTH_LONG).show()
            finish()
        }else{
            Toast.makeText(this, "los campos deben tener texto", Toast.LENGTH_LONG).show()
        }



    }


}