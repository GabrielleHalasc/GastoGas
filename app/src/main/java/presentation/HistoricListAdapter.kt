package com.example.conversormoedas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import data.HistoricItem

class HistoricListAdapter(
) : RecyclerView.Adapter<HistoricListViewHolder>() {

    private var historyList: List<HistoricItem> = listOf()
    private lateinit var onClickListener: (HistoricItem) -> Unit

    fun submitList(list: List<HistoricItem>) {
        this.historyList = list
        notifyDataSetChanged()
    }

    fun setOnDeleteClickListener(onClick: (HistoricItem) -> Unit) {
        this.onClickListener = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_historic, parent, false)
        return HistoricListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: HistoricListViewHolder, position: Int) {
        val item = historyList[position]
        holder.bind(item, onClickListener)
    }
}

class HistoricListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvDistancia = view.findViewById<TextView>(R.id.txt_historico_distancia)
    val tvPreco = view.findViewById<TextView>(R.id.txt_historico_preco)
    val tvGasto = view.findViewById<TextView>(R.id.txt_historico_gasto)
    val btnDelete = view.findViewById<ImageButton>(R.id.btn_delete_task)

    fun bind(
        item: HistoricItem,
        onClickListener: (HistoricItem) -> Unit
    ) {
        btnDelete.setOnClickListener {
            onClickListener(item)
        }
        tvPreco.text = "Gasolina $ ${item.preco}"
        tvDistancia.text = " ${item.distancia} KM"
        tvGasto.text = "Gasto total $ ${item.gasto}"
    }

}

