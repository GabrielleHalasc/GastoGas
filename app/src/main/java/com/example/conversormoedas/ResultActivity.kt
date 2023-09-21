package com.example.conversormoedas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val txtPreco = findViewById<TextView>(R.id.txt_preco)
        val txtConsumo = findViewById<TextView>(R.id.txt_consumo)
        val txtDistancia = findViewById<TextView>(R.id.txt_distancia)
        val txtResult = findViewById<TextView>(R.id.txt_result)
        val btnNovoCalculo = findViewById<Button>(R.id.btn_novo_calculo)

        val preco = intent.getFloatExtra("Extra_Preco", 0.1f)
        val consumo = intent.getFloatExtra("Extra_Consumo", 0.1f)
        val distancia = intent.getFloatExtra("Extra_Distancia", 0.1f)

        txtPreco.text = preco.toString()
        txtConsumo.text = consumo.toString()
        txtDistancia.text = distancia.toString()

        val resultado = (distancia / consumo) * preco

        txtResult.text = "$$resultado"

        btnNovoCalculo.setOnClickListener {

            val intent = Intent(this, PriceActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

    }
}