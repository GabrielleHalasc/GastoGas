package presentation


import androidx.lifecycle.ViewModel

class ResultActivityViewModel: ViewModel() {

    fun gasto(distancia:Float, consumo: Float, preco :Float) : Float {
        val resultado : Float = (distancia / consumo) * preco
        return resultado
    }
}