package com.hgarcia.idgs905baseandroid.MultiplicaAB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hgarcia.idgs905baseandroid.R

class multiplicaAB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplica_ab)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtA = findViewById<EditText>(R.id.edtA)
        val edtB = findViewById<EditText>(R.id.edtB)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)

        btnMultiplicar.setOnClickListener {
            val aStr = edtA.text.toString()
            val bStr = edtB.text.toString()

            if (aStr.isNotEmpty() && bStr.isNotEmpty()) {
                val intent = Intent(this, ResultMultiplicaActivity::class.java)
                intent.putExtra("EXTRA_A", aStr.toInt())
                intent.putExtra("EXTRA_B", bStr.toInt())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor llena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}