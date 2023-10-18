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

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price)

        val tietPreco = findViewById<TextInputEditText>(R.id.tiet_preco_combustivel)
        val tilPreco = findViewById<TextInputLayout>(R.id.til_preco_combustivel)
        val btnProximoPreco = findViewById<Button>(R.id.btn_proximo_preco)

        val imgButton = findViewById<ImageButton>(R.id.imgbtn_voltar1)

        imgButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


        btnProximoPreco.setOnClickListener {

            val precoString = tietPreco.text.toString()

            if (precoString.isEmpty()) {
                tilPreco.error = "*Preço do combustivel obrigatório"
            } else {
                tilPreco.error = null
                tilPreco.isErrorEnabled = false
            }
            if (precoString.isNotEmpty()) {
                val preco: Float = precoString.toFloat()

                val intent = Intent(this, ConsumeActivity::class.java)
                    .apply {
                        putExtra("Extra_Preco", preco)
                    }
                startActivity(intent)
            }


        }
    }
}