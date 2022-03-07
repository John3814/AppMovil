package com.example.appmovil
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table CuentaxCobrar(id INTEGER PRIMARY KEY AUTOINCREMENT, date text,concept text, value int,dateLim text, name text,nameID int,phone int)")
        db?.execSQL("create table CuentaxPagar(id INTEGER PRIMARY KEY AUTOINCREMENT, date text,concept text, value int,dateLim text, name text,nameID int,phone int)")
        db?.execSQL("create table Ingresos (id INTEGER PRIMARY KEY  AUTOINCREMENT, date  text,concept text,value int)")
        db?.execSQL("create table Egresos (id INTEGER PRIMARY KEY AUTOINCREMENT, date text,concept text,value int)" )

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}
