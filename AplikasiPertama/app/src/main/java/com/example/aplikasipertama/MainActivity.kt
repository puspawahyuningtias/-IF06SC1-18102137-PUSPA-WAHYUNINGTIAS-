package com.example.aplikasipertama

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inisialisasi komponen
        var edTglLahir = findViewById<EditText>(R.id.ed_tanggal_lahir)
        var btnKlik = findViewById<Button>(R.id.btn_klik)
        var tvHasil = findViewById<EditText>(R.id.tv_hasil)

        btnKlik.setOnClickListener(){
            val input = edTglLahir.text.toString()
            val hasil = when(input.toInt()){
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "X"
                in 1981..1995 -> "Milenial"
                in 1996..2010 -> "Z"
                else -> "Gatau"
            }
            tvHasil.text ="Kamu Generasi $hasil"
        }
    }
}