package com.example.conversormoedas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distance)

        val imgButton = findViewById<ImageButton>(R.id.imgbtn_voltar3)

        imgButton.setOnClickListener(View.OnClickListener {
            finish()
        })

        val tietDistance = findViewById<TextInputEditText>(R.id.tiet_distance)
        val tilDistance = findViewById<TextInputLayout>(R.id.til_distance)
        val btnResult = findViewById<Button>(R.id.btn_resultado)
        val preco = intent.getFloatExtra("Extra_Preco", 0.1f)
        val consumo = intent.getFloatExtra("Extra_Consumo", 0.1f)

        btnResult.setOnClickListener {

            val distanciaString = tietDistance.text.toString()

            if (distanciaString.isEmpty()) {
                tilDistance.error = "Consumo do veiculo obrigatório"
            } else {
                tilDistance.error = null
                tilDistance.isErrorEnabled = false
            }
            if (distanciaString.isNotEmpty()) {
                val distancia: Float = distanciaString.toFloat()

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("Extra_Preco", preco)
                        putExtra("Extra_Consumo", consumo)
                        putExtra("Extra_Distancia", distancia)
                    }
                startActivity(intent)
            }
        }


    }
}