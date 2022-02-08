package com.example.appmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    var boton : Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton = findViewById(R.id.Button_ingreso)

        boton!!.setOnClickListener{
            setContentView(R.layout.activity_ingreso)
        }

    }


}