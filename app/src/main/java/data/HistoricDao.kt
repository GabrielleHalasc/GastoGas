package data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import data.HistoricItem


@Dao
interface HistoricDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: HistoricItem)

    @Query("Select * from HistoricItem")
    fun getAll(): LiveData<List<HistoricItem>>

    @Query("Delete from HistoricItem")
    fun deleteAll()

    @Query("Delete from  HistoricItem WHERE id = :id ")
    fun deleteById(id: Int)




}