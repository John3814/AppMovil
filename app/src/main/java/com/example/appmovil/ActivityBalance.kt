package com.example.appmovil

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TextView

class ActivityBalance : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var tlBalance:TableLayout?=null
    private var spinnerListBy = 0
    private var spinnerBySort = 0
    private val con=SQLite(this,"basemovil",null,1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)

        tlBalance=findViewById(R.id.tlBalance)

        findViewById<Spinner>(R.id.spinnerList).onItemSelectedListener=this
        findViewById<Spinner>(R.id.spinnerSort).onItemSelectedListener=this

    }
    private fun selectSpinnerTable() {
        spinnerListBy=findViewById<Spinner>(R.id.spinnerList).selectedItemPosition

        when (spinnerListBy) {
            0 -> {
                consult("Ingresos")
            }
            1 -> {
                consult("Egresos")
            }
            2 -> {
                consult("CuentaxPagar")
            }
            else -> {
                consult("CuentaxCobrar")
            }
        }
    }
    private fun consult(schem:String){
        spinnerBySort=findViewById<Spinner>(R.id.spinnerSort).selectedItemPosition
        val fila:Cursor
        val baseDatos=con.writableDatabase
        when(spinnerBySort){
            0 -> {
                fila=baseDatos.rawQuery("select id,date,concept,value from $schem" ,null)
                llenarTabla(fila)
            }
            1 -> {
                fila=baseDatos.rawQuery("select id,date,concept,value from $schem where date" ,null)
                llenarTabla(fila)
            }
            2 -> {
                fila=baseDatos.rawQuery("select id,date,concept,value from $schem where value ORDER BY value desc" ,null)
                llenarTabla(fila)
            }

        }
    }


    private fun llenarTabla(fila:Cursor){
        tlBalance?.removeAllViews()
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

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        selectSpinnerTable()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}

