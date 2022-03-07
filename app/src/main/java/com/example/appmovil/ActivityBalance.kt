package com.example.appmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView

class ActivityBalance : AppCompatActivity() {
    var tlBalance:TableLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)

        tlBalance=findViewById(R.id.tlBalance)
        llenarTabla()
    }

    fun llenarTabla(){

        val con=SQLite(this,"basemovil",null,1)
        val baseDatos=con.writableDatabase
        val fila=baseDatos.rawQuery("select id,date,concept,value from Ingresos",null)
        fila.moveToFirst()
        do {
            val registro=LayoutInflater.from(this).inflate(R.layout.item_table,null,false)
            val tvID=registro.findViewById<View>(R.id.tvID) as TextView
            val tvDate=registro.findViewById<View>(R.id.tvDate) as TextView
            val tvConcept=registro.findViewById<View>(R.id.tvConcept) as TextView
            val tvValue=registro.findViewById<View>(R.id.tvValue) as TextView
            tvID.setText(fila.getString(0))
            tvDate.setText(fila.getString(1))
            tvConcept.setText(fila.getString(2))
            tvValue.setText(fila.getString(3))
            tlBalance?.addView(registro)


        }while (fila.moveToNext())

    }
}