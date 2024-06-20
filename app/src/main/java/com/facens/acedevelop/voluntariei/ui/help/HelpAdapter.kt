package com.facens.acedevelop.voluntariei.ui.help

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facens.acedevelop.voluntariei.databinding.CardTextBinding
import com.facens.acedevelop.voluntariei.domain.models.Help
import com.facens.acedevelop.voluntariei.utils.BaseAdapter

class HelpAdapter :BaseAdapter<HelpAdapter.HelpViewHolder,Help>() {

    inner class HelpViewHolder(val binding: CardTextBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder {
        val binding = CardTextBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HelpViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        holder.binding.Title.text = items[position].title
        holder.binding.Description.text = items[position].description
    }
}