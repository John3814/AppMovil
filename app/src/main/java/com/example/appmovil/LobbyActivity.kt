package com.example.appmovil


import android.content.Intent
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView


class LobbyActivity : AppCompatActivity() {
    private val con = SQLite(this, "basemovil", null, 1)

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

        findViewById<Button>(R.id.Button_balance).setOnClickListener(){
            jumpActivityBalance()
        }

        income()
        expenditure()
        utility()

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
    private fun jumpActivityBalance(){
        val intent: Intent = Intent(this,ActivityBalance::class.java)
        startActivity(intent)
    }

    private fun income(){
        // puede crear una tabla para los resultados  en sql y  sumar en ella misma  para  depues  ver en  pantalla

    }

    private fun expenditure(){

    }

    private fun utility(){

    }

    // para ver si  esta  vacio  true para vacio
    private fun checkEmpty(db: SQLiteDatabase?, tabla: String?): Boolean {
        return DatabaseUtils.queryNumEntries(db, tabla) == 0L
    }


}