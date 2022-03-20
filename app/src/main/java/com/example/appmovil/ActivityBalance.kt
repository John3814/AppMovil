package com.example.appmovil

import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class ActivityBalance : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var tlBalance: TableLayout? = null
    private var spinnerListBy = 0
    private var spinnerBySort = 0
    var balanceID: EditText? = null
    private val con = SQLite(this, "basemovil", null, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)

        tlBalance = findViewById(R.id.tlBalance)

        balanceID = findViewById(R.id.TextBalanceID)

        findViewById<Spinner>(R.id.spinnerList).onItemSelectedListener = this

        findViewById<Spinner>(R.id.spinnerSort).onItemSelectedListener = this

        findViewById<Button>(R.id.buttonSearch).setOnClickListener() {
            searchConsult()
        }
    }

    private fun searchConsult() {
        val schem = selectSpinnerTable()
        val baseDatos = con.writableDatabase
        val valu = balanceID?.text
        val fila = baseDatos.rawQuery("select id,date,concept,value from $schem where id='$valu'", null)

        if (!checkEmpty(baseDatos, schem) && !valu.toString().isEmpty() && Integer.parseInt(valu.toString())<fila.columnCount ) {
            llenarTabla(fila)
        }
        else{
            tlBalance?.removeAllViews()
            Toast.makeText(this, "No se econtro el dato", Toast.LENGTH_LONG).show()
        }
    }

    private fun selectSpinnerTable(): String {
        spinnerListBy = findViewById<Spinner>(R.id.spinnerList).selectedItemPosition

        return when (spinnerListBy) {
            0 -> {
                "Ingresos"
            }
            1 -> {
                "Egresos"
            }
            2 -> {
                "CuentaxPagar"
            }
            else -> {
                "CuentaxCobrar"
            }
        }
    }

    private fun consult(schem: String) {
        spinnerBySort = findViewById<Spinner>(R.id.spinnerSort).selectedItemPosition
        val fila: Cursor
        val baseDatos = con.writableDatabase
        if (!checkEmpty(baseDatos, schem)) {
            when (spinnerBySort) {
                0 -> {
                    fila = baseDatos.rawQuery("select id,date,concept,value from $schem", null)
                    llenarTabla(fila)
                }
                1 -> {
                    fila = baseDatos.rawQuery("select id,date,concept,value from $schem where date", null)
                    llenarTabla(fila)
                }
                2 -> {
                    fila = baseDatos.rawQuery("select id,date,concept,value from $schem where value ORDER BY value desc", null)
                    llenarTabla(fila)
                }
            }
        } else {
            tlBalance?.removeAllViews()
        }
    }

    private fun llenarTabla(fila: Cursor) {
        tlBalance?.removeAllViews()

        fila.moveToFirst()
        do {
            val registro = LayoutInflater.from(this).inflate(R.layout.item_table, null, false)
            val tvID = registro.findViewById<View>(R.id.tvID) as TextView
            val tvDate = registro.findViewById<View>(R.id.tvDate) as TextView
            val tvConcept = registro.findViewById<View>(R.id.tvConcept) as TextView
            val tvValue = registro.findViewById<View>(R.id.tvValue) as TextView
            tvID.setText(fila.getString(0))
            tvDate.setText(fila.getString(1))
            tvConcept.setText(fila.getString(2))
            tvValue.setText(fila.getString(3))
            tlBalance?.addView(registro)
        } while (fila.moveToNext())

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        consult(selectSpinnerTable())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    private fun checkEmpty(db: SQLiteDatabase?, tabla: String?): Boolean {
        return DatabaseUtils.queryNumEntries(db, tabla) == 0L
    }
}