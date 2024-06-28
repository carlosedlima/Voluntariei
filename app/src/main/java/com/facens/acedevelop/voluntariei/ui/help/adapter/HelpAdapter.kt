package com.facens.acedevelop.voluntariei.ui.help.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facens.acedevelop.voluntariei.databinding.CardTextBinding
import com.facens.acedevelop.voluntariei.domain.models.Help
import com.facens.acedevelop.voluntariei.ui.help.details.HelpDetailsActivity
import com.facens.acedevelop.voluntariei.utils.BaseAdapter
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.HELP_ID

class HelpAdapter(private val context: Context) :BaseAdapter<HelpAdapter.HelpViewHolder,Help>() {

    inner class HelpViewHolder(val binding: CardTextBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder {
        val binding = CardTextBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HelpViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        val help = items[position]

        holder.binding.Title.text = help.title
        holder.binding.Description.text = help.description

        holder.itemView.setOnClickListener {

            val intent = Intent(context, HelpDetailsActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(HELP_ID, help)
            }
            context.startActivity(intent)
        }
    }
}