package com.example.appmovil


import android.content.Intent
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat


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

        lobbyoperation()

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

    private fun lobbyoperation() {
        val baseDatos = con.writableDatabase

        var fila = baseDatos.rawQuery("select SUM(value) as total from Ingresos ", null)
        fila.moveToNext()
        val income = fila.getDouble(0)
        findViewById<TextView>(R.id.textViewIncome).text = doubleOutString(income)

        fila = baseDatos.rawQuery("select SUM(value) as total from Egresos ", null)
        fila.moveToNext()
        val expenditure = fila.getDouble(0)
        findViewById<TextView>(R.id.textViewExpenditure).text = doubleOutString(expenditure)

        val utility = income - expenditure
        findViewById<TextView>(R.id.textViewUtility).text = doubleOutString(utility )

        if (utility < 0) {
            findViewById<TextView>(R.id.textViewUtility).setTextColor(Color.parseColor("#ffcc0000"))
        } else {
            findViewById<TextView>(R.id.textViewUtility).setTextColor(Color.parseColor("#ff669900"))
        }

    }
    fun doubleOutString(Número: Double): String? {
        return DecimalFormat("#.####################################").format(Número)
    }
}


