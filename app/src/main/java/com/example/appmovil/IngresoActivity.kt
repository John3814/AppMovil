package com.example.appmovil

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IngresoActivity: AppCompatActivity()  {
    //var txtFecha:EditText?=null
    //var txtConcepto:EditText?=null
    //var txtValor:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)
        /*
        txtFecha=findViewById(R.id.txtFecha)
        txtConcepto=findViewById(R.id.txtConcepto)
        txtValor=findViewById(R.id.txtValor)
*/
    }
    /*
    fun insertar(view:View){
        var con=SQLite(this,"basemovil",null,1)
        var baseDatos=con.writableDatabase

        var fecha=txtFecha?.text.toString()
        var concepto=txtConcepto?.text.toString()
        var valor=txtValor?.text.toString()

        if(fecha.isEmpty()==false && concepto.isEmpty()==false && valor.isEmpty()==false){
            var registro=ContentValues()
            registro.put("fecha",fecha)
            registro.put("concepto",concepto)
            registro.put("valor",valor)
            baseDatos.insert("Ingresos",null,registro)
            txtFecha?.setText("")
            txtConcepto?.setText("")
            txtValor?.setText("")
            Toast.makeText(this, "el ingreso se ha guardado", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "los campos deben tener texto", Toast.LENGTH_LONG).show()
        }


    }

     */
}