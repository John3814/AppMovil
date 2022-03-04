package com.example.appmovil


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class LobbyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)

        findViewById<Button>(R.id.Button_ingreso).setOnClickListener(){
            jumpActivityIngreso()
        }
        findViewById<Button>(R.id.Button_egresos).setOnClickListener(){
            jumpActivityEgreso()
        }
        findViewById<Button>(R.id.Button_cuentas_cobrar).setOnClickListener(){
            jumpActivityCuentaPorCobrar()
        }
        findViewById<Button>(R.id.Button_cuentas_pagar).setOnClickListener(){
            jumpActivityCuentaPorPagar()
        }

    }

    private fun jumpActivityIngreso(){
        val intent: Intent = Intent(this,IngresoActivity::class.java)
        startActivity(intent)
    }
    private fun jumpActivityEgreso(){
        val intent: Intent = Intent(this,EgresoActivity::class.java)
        startActivity(intent)
    }
    private fun jumpActivityCuentaPorCobrar(){
        val intent: Intent = Intent(this,Cuenta_por_cobrarActivity::class.java)
        startActivity(intent)
    }
    private fun jumpActivityCuentaPorPagar(){
        val intent: Intent = Intent(this,Cuenta_por_pagarActivity::class.java)
        startActivity(intent)
    }

}