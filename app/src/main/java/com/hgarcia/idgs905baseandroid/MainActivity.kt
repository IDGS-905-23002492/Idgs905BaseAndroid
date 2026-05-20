package com.hgarcia.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hgarcia.idgs905baseandroid.Ejemplo1.ejemplo1
import com.hgarcia.idgs905baseandroid.Ejemplo2.ejemplo2
import com.hgarcia.idgs905baseandroid.Ejemplo3.ejemplo3
import com.hgarcia.idgs905baseandroid.R.id
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnEjemplo1 = findViewById<Button>(id.btn1)
        val btnEjemplo2 = findViewById<Button>(id.btn2)
        val btnEjemplo3 = findViewById<Button>(id.btn3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnEjemplo1.setOnClickListener { navegateToEjemlo1() }
        btnEjemplo2.setOnClickListener { navegateToEjemplo2() }
        btnEjemplo3.setOnClickListener { navigateToEjemplo3() }


}
    fun navegateToEjemlo1(){
    val intent = Intent(this, ejemplo1::class.java)
    startActivity(
        intent
    )
    }
    fun navegateToEjemplo2(){
        val intent = Intent(this, ejemplo2::class.java )
        startActivity(
            intent
        )
    }
    fun navigateToEjemplo3(){
        val intent = Intent(this, ejemplo3::class.java)
        startActivity(
            intent
        )
    }
}