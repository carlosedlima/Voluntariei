package com.facens.acedevelop.voluntariei.ui.home.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.facens.acedevelop.voluntariei.databinding.CardEventoBinding
import com.facens.acedevelop.voluntariei.domain.models.Event
import com.facens.acedevelop.voluntariei.ui.home.details.EventDetailsActivity
import com.facens.acedevelop.voluntariei.utils.BaseAdapter
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.EVENT_ID
import com.facens.acedevelop.voluntariei.utils.dateToString

class  EventsAdapter(private val context: Context): BaseAdapter<EventsAdapter.EventHolder,Event>() {

    inner class EventHolder(val binding: CardEventoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val binding = CardEventoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  EventHolder(binding)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        val evento = items[position]

        holder.binding.Nome.text = evento.nome
        holder.binding.Data.text = evento.data.dateToString("dd/MM/yyyy")
        holder.binding.Descricao.text = evento.descricao

        holder.itemView.setOnClickListener {
            val intent = Intent(context, EventDetailsActivity::class.java).apply {
                putExtra(EVENT_ID, evento)
            }
            context.startActivity(intent)
        }
    }


}