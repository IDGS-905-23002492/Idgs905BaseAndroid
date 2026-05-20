package com.hgarcia.idgs905baseandroid.Ejemplo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hgarcia.idgs905baseandroid.R

class ejemplo1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNumero1 = findViewById<EditText>(R.id.edtNumero1)
        val edtNumero2 = findViewById<EditText>(R.id.edtNumero2)
        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnSuma.setOnClickListener {
            val num1Txt = edtNumero1.text.toString()
            val num2Txt = edtNumero2.text.toString()

            if (num1Txt.isNotEmpty() && num2Txt.isNotEmpty()) {
                val suma = num1Txt.toDouble() + num2Txt.toDouble()
                txtResultado.text = "Resultado: $suma"
            } else {
                Toast.makeText(this, "Por favor llena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}