package com.example.conversormoedas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ResultActivity : AppCompatActivity() {

    private val dataBase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "Historic-database"
        ).build()
    }

    private val dao by lazy { dataBase.HistoricDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val txtPreco = findViewById<TextView>(R.id.txt_preco)
        val txtConsumo = findViewById<TextView>(R.id.txt_consumo)
        val txtDistancia = findViewById<TextView>(R.id.txt_distancia)
        val txtResult = findViewById<TextView>(R.id.txt_result)
        val btnNovoCalculo = findViewById<Button>(R.id.btn_novo_calculo)
        val btnHistorico = findViewById<Button>(R.id.btn_historico)

        val preco = intent.getFloatExtra("Extra_Preco", 0.1f)
        val consumo = intent.getFloatExtra("Extra_Consumo", 0.1f)
        val distancia = intent.getFloatExtra("Extra_Distancia", 0.1f)

        txtPreco.text = preco.toString()
        txtConsumo.text = consumo.toString()
        txtDistancia.text = distancia.toString()

        val resultado = (distancia / consumo) * preco

        txtResult.text = "$$resultado"

        val item = HistoricItem(preco = preco, gasto = resultado, distancia = distancia)
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(item)
        }
        btnNovoCalculo.setOnClickListener {

            val intent = Intent(this, PriceActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        btnHistorico.setOnClickListener {
            val intent = Intent(this, HistoricActivity::class.java)
            startActivity(intent)
        }

    }
}