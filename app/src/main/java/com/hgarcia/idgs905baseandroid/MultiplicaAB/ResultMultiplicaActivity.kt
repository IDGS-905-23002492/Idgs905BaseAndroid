package com.hgarcia.idgs905baseandroid.MultiplicaAB

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hgarcia.idgs905baseandroid.R

class ResultMultiplicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_multiplica)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtDesarrollo = findViewById<TextView>(R.id.txtDesarrollo)

        val a = intent.getIntExtra("EXTRA_A", 0)
        val b = intent.getIntExtra("EXTRA_B", 0)

        var resultado = 0
        val cadenaSuma = StringBuilder()

        for (i in 1..b) {
            resultado += a
            cadenaSuma.append(a)
            if (i < b) {
                cadenaSuma.append("+")
            }
        }

        txtDesarrollo.text = "$cadenaSuma = $resultado"
    }
}