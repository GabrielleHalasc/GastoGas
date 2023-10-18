package data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoricItem(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val preco: Float,
    val gasto: Float,
    val distancia: Float,
)

