package com.hgarcia.idgs905baseandroid.ExamenResistencias

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hgarcia.idgs905baseandroid.R

class calculadoraResistencias : AppCompatActivity() {

    private  val colores = arrayOf("Negro","Cafe","Rojo","Naranja","Amarillo","Verde","Azul", "Violeta", "Gris", "Blanco")
    private val multiplicadores = doubleArrayOf(1.0, 10.0, 100.0, 1000.0, 10000.0, 100000.0, 1000000.0, 10000000.0, 100000000.0, 1000000000.0)
    private val coloresHexadecimal= arrayOf(
        "#000000",
        "#8B4513",
        "#FF0000",
        "#FFA500",
        "#FFFF00",
        "#008000",
        "#0000FF",
        "#EE82EE",
        "#808080",
        "#FFFFFF"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora_resistencias)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spBanda1 = findViewById<Spinner>(R.id.spBanda1)
        val spBanda2 = findViewById<Spinner>(R.id.spBanda2)
        val spMultiplicador = findViewById<Spinner>(R.id.spMultiplicador)
        val txtValBanda1=findViewById<TextView>(R.id.txtValBanda1)
        val txtValBanda2=findViewById<TextView>(R.id.txtValBanda2)
        val txtValMultiplicador=findViewById<TextView>(R.id.txtValMultiplicador)
        val rgTolerancia = findViewById<RadioGroup>(R.id.rgTolerancia)
        val rbOro = findViewById<RadioButton>(R.id.rbOro)
        val rbPlata = findViewById<RadioButton>(R.id.rbPlata)
        val txtOhm = findViewById<TextView>(R.id.txtOhm)
        val txtMaximo = findViewById<TextView>(R.id.txtMaximo)
        val txtMinimo = findViewById<TextView>(R.id.txtMinimo)
        val btnCalcularResistencia = findViewById<Button>(R.id.btnCalcularResistencia)

        val adapterColores = ArrayAdapter(this, android.R.layout.simple_spinner_item, colores)
            adapterColores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spBanda1.adapter = adapterColores
        spBanda2.adapter = adapterColores
        spMultiplicador.adapter = adapterColores

        spBanda1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                txtValBanda1.text = position.toString()
                txtValBanda1.setBackgroundColor(android.graphics.Color.parseColor(coloresHexadecimal[position]))
                if (position == 4 || position == 9) txtValBanda1.setTextColor(android.graphics.Color.BLACK)
                else txtValBanda1.setTextColor(android.graphics.Color.WHITE)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        spBanda2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                txtValBanda2.text = position.toString()
                txtValBanda2.setBackgroundColor(android.graphics.Color.parseColor(coloresHexadecimal[position]))
                if (position == 4 || position == 9) txtValBanda2.setTextColor(android.graphics.Color.BLACK)
                else txtValBanda2.setTextColor(android.graphics.Color.WHITE)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        spMultiplicador.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val mult = multiplicadores[position]
                txtValMultiplicador.text = mult.toLong().toString()
                txtValMultiplicador.setBackgroundColor(android.graphics.Color.parseColor(coloresHexadecimal[position]))
                if (position == 4 || position == 9) txtValMultiplicador.setTextColor(android.graphics.Color.BLACK)
                else txtValMultiplicador.setTextColor(android.graphics.Color.WHITE)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        val btnCalcular = null
        btnCalcularResistencia.setOnClickListener {
            val b1 = spBanda1.selectedItemPosition
            val b2 = spBanda2.selectedItemPosition
            val mult = multiplicadores[spMultiplicador.selectedItemPosition]

            val valorBase = ((b1 * 10) + b2) * mult
            val porcentajeTolerancia = if (rbOro.isChecked) 0.05 else 0.10

            val toleranciaCalculada = valorBase * porcentajeTolerancia
            val valorMax = valorBase + toleranciaCalculada
            val valorMin = valorBase - toleranciaCalculada

            txtOhm.text = "valor ohm: ${valorBase.toLong()}"
            txtMaximo.text = "valor maximo: ${valorMax.toLong()}"
            txtMinimo.text = "valor minimo: ${valorMin.toLong()}"
        }

    }
}