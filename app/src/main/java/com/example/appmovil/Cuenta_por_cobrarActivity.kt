package com.example.appmovil

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Cuenta_por_cobrarActivity: AppCompatActivity() {

    var txtDate:EditText?=null
    var txtConcept:EditText?=null
    var txtValue:EditText?=null
    var txtDateLim:EditText?=null
    var txtName:EditText?=null
    var txtNameID:EditText?=null
    var txtPhone:EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuenta_por_cobrar)

        txtDate=findViewById(R.id.textDateCobrar)
        txtConcept=findViewById(R.id.txtConcept)
        txtValue=findViewById(R.id.txtValue)
        txtDateLim=findViewById(R.id.textDateCobrarLimit)
        txtName=findViewById(R.id.txtName)
        txtNameID=findViewById(R.id.txtNameID)
        txtPhone=findViewById(R.id.txtPhone)

        findViewById<EditText>(R.id.textDateCobrar).setOnClickListener(){
            showDatePikerDialog()
        }

        findViewById<EditText>(R.id. textDateCobrarLimit).setOnClickListener(){
            showDatePikerDialogLimit()
        }
    }
    private fun showDatePikerDialog() {
        val datePicker=DatePickerFragment({day,month,year-> onDateSelected(year,month,day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }

    private fun onDateSelected(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.textDateCobrar).setText("$day/$month/$year")
    }

    private fun showDatePikerDialogLimit() {
        val datePicker=DatePickerFragmentLimit({day,month,year-> onDateSelectedLimit(year,month,day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }

    private fun onDateSelectedLimit(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.textDateCobrarLimit).setText("$day/$month/$year")
    }


    fun insertar(view: View){
        var con=SQLite(this,"basemovil",null,1)
        var baseDatos=con.writableDatabase

        var fecha=txtDate?.text.toString()
        var concepto=txtConcept?.text.toString()
        var valor=txtValue?.text.toString()
        var fechaLim=txtDateLim?.text.toString()
        var nombre=txtName?.text.toString()
        var nombreID=txtNameID?.text.toString()
        var celular=txtPhone?.text.toString()

        if(fecha.isEmpty()==false && concepto.isEmpty()==false && valor.isEmpty()==false && fechaLim.isEmpty()==false && nombre.isEmpty()==false && nombreID.isEmpty()==false && celular.isEmpty()==false){
            var registro= ContentValues()

            registro.put("date",fecha)
            registro.put("concept",concepto)
            registro.put("value",valor)
            registro.put("dateLim",fechaLim)
            registro.put("name",nombre)
            registro.put("nameID",nombreID)
            registro.put("phone",celular)

            baseDatos.insert("CuentaxCobrar",null,registro)
            txtDate?.setText("")
            txtConcept?.setText("")
            txtValue?.setText("")
            txtDateLim?.setText("")
            txtName?.setText("")
            txtNameID?.setText("")
            txtPhone?.setText("")
            Toast.makeText(this, "la cuenta por cobrar se ha guardado", Toast.LENGTH_LONG).show()
            finish()
        }else{
            Toast.makeText(this, "los campos deben tener texto", Toast.LENGTH_LONG).show()
        }
    }
}