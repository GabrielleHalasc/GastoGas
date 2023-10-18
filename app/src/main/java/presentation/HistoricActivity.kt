package presentation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.conversormoedas.HistoricListAdapter
import com.example.conversormoedas.R
import data.AppDataBase
import data.HistoricItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HistoricActivity : AppCompatActivity() {


    private val viewModel: HistoricListViewModel by lazy {
        HistoricListViewModel.create(application)
    }
    private lateinit var historicList: RecyclerView
    private val adapter = HistoricListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = ""

        val btnVoltar = findViewById<ImageButton>(R.id.imgbtn_voltar4)

        btnVoltar.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }

        historicList = findViewById<RecyclerView>(R.id.rv_historic)
        historicList.adapter = adapter

        listFromDataBase()

       adapter.setOnDeleteClickListener {
           viewModel.deleteById(it.id)
       }

    }
    override fun onStart() {
        super.onStart()
        listFromDataBase()
    }


    private fun listFromDataBase() {

      val listObserver = Observer<List<HistoricItem>>{
          adapter.submitList(it)
      }
        viewModel.historicListLiveData.observe(this@HistoricActivity, listObserver)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_delete, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_delete_all -> {
                viewModel.deleteAll()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}
