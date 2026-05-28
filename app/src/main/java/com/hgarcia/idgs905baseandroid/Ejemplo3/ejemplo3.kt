package com.hgarcia.idgs905baseandroid.Ejemplo3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hgarcia.idgs905baseandroid.R

class ejemplo3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnStar = findViewById<AppCompatButton>(R.id.btnStar)
        val edtName = findViewById<AppCompatEditText>(R.id.edtName)

        btnStar.setOnClickListener {
            val name = edtName.text.toString().trim()

            if (name.isNotEmpty()) {
                // Se corrigió el uso de la coma en lugar del punto
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor escribe un nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }
}