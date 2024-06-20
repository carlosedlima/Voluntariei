package com.facens.acedevelop.voluntariei.ui.home.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.facens.acedevelop.voluntariei.databinding.CardEventoBinding
import com.facens.acedevelop.voluntariei.domain.models.Event
import com.facens.acedevelop.voluntariei.utils.BaseAdapter
import com.facens.acedevelop.voluntariei.utils.dateToString

class  EventsAdapter: BaseAdapter<EventsAdapter.EventHolder,Event>() {

    inner class EventHolder(val binding: CardEventoBinding): RecyclerView.ViewHolder(binding.root)

    private var onItemClickListener: ((Event) -> Unit)? = null

    fun setOnItemClickListener(listener: (Event) -> Unit) {
        onItemClickListener = listener
    }

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
            onItemClickListener?.invoke(evento)
        }
    }


}