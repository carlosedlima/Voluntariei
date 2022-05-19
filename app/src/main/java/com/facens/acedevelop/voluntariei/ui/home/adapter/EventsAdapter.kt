package com.facens.acedevelop.voluntariei.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facens.acedevelop.voluntariei.databinding.CardEventoBinding
import com.facens.acedevelop.voluntariei.domain.models.Evento
import com.facens.acedevelop.voluntariei.utils.BaseAdapter

class EventsAdapter: BaseAdapter<EventsAdapter.EventHolder,Evento>() {

    inner class EventHolder(val binding: CardEventoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val binding = CardEventoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  EventHolder(binding)
    }
    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.binding.Nome.text = items[position].nome
        holder.binding.Data.text = items[position].data.toString()
        holder.binding.Descricao.text = items[position].descricao
        holder.binding.Ong.text = items[position].ong.name
    }


}