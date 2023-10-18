package presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.conversormoedas.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ConsumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consume)

        val imgButton = findViewById<ImageButton>(R.id.imgbtn_voltar2)

        imgButton.setOnClickListener(View.OnClickListener {
            finish()
        })

        val tietConsumo = findViewById<TextInputEditText>(R.id.tiet_consumo_kml)
        val tilConsumo = findViewById<TextInputLayout>(R.id.til_consumo_kml)
        val btnProximoConsumo = findViewById<Button>(R.id.btn_proximo_consumo)
        val preco = intent.getFloatExtra("Extra_Preco", 0.1f)

        btnProximoConsumo.setOnClickListener {
            val consumoString = tietConsumo.text.toString()

            if (consumoString.isEmpty()) {
                tilConsumo.error = "Consumo do veiculo obrigatório"
            } else {
                tilConsumo.error = null
                tilConsumo.isErrorEnabled = false
            }

            if (consumoString.isNotEmpty()) {
                val consumo: Float = consumoString.toFloat()

                val intent = Intent(this, DistanceActivity::class.java)
                    .apply {
                        putExtra("Extra_Preco", preco)
                        putExtra("Extra_Consumo", consumo)
                    }
                startActivity(intent)
            }
        }
    }
}