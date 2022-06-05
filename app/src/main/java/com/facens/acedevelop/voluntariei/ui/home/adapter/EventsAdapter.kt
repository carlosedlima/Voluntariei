package com.facens.acedevelop.voluntariei.ui.home.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.facens.acedevelop.voluntariei.databinding.CardEventoBinding
import com.facens.acedevelop.voluntariei.domain.models.Evento
import com.facens.acedevelop.voluntariei.utils.BaseAdapter
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class EventsAdapter: BaseAdapter<EventsAdapter.EventHolder,Evento>() {

    inner class EventHolder(val binding: CardEventoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val binding = CardEventoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  EventHolder(binding)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        holder.binding.Nome.text = items[position].nome
        holder.binding.Data.text = items[position].data.dateToString("dd-MM-yyyy")
        holder.binding.Descricao.text = items[position].descricao
    }

    private fun Date.dateToString(format: String): String {
        //simple date formatter
        val dateFormatter = SimpleDateFormat(format, Locale.getDefault())

        //return the formatted date string
        return dateFormatter.format(this)
    }
}