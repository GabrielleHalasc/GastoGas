package data

import androidx.room.Database
import androidx.room.RoomDatabase
import data.HistoricDao
import data.HistoricItem

@Database(entities = [HistoricItem::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun HistoricDao(): HistoricDao
}