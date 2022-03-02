package com.example.appmovil

import Models.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    var boton : Button?=null
    var boton_2 : Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton = findViewById(R.id.Button_ingreso)

        boton!!.setOnClickListener{
            setContentView(R.layout.activity_ingreso)
        }

        boton_2 = findViewById(R.id.Button_cuentas_cobrar)

        boton_2!!.setOnClickListener{
            setContentView(R.layout.cuenta_por_cobrar)
        }

    }

}