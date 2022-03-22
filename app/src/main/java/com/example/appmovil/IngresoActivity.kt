package com.example.appmovil

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class IngresoActivity: AppCompatActivity()  {
    var txtDate:EditText?=null
    var txtConcept:EditText?=null
    var txtV:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        txtDate=findViewById(R.id.textDateIngreso)
        txtConcept=findViewById(R.id.txtConcept)
        txtV=findViewById(R.id.txtValue)

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

        var fecha=txtDate?.text.toString()
        var concepto=txtConcept?.text.toString()
        var valor=txtV?.text.toString()

        if(fecha.isEmpty()==false && concepto.isEmpty()==false && valor.isEmpty()==false){
            var registro=ContentValues()

            registro.put("concept",concepto)
            registro.put("value",valor)
            registro.put("date",fecha)
            baseDatos.insert("Ingresos",null,registro)
            txtDate?.setText("")
            txtConcept?.setText("")
            txtV?.setText("")
            Toast.makeText(this, "el ingreso se ha guardado", Toast.LENGTH_LONG).show()
            finish()
        }else{
            Toast.makeText(this, "los campos deben tener texto", Toast.LENGTH_LONG).show()
        }



    }


}