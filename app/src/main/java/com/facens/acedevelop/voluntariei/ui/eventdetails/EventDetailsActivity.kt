package com.facens.acedevelop.voluntariei.ui.eventdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facens.acedevelop.voluntariei.databinding.ActivityEventDetailsBinding
import com.facens.acedevelop.voluntariei.domain.models.Event
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.EVENT_ID
import com.facens.acedevelop.voluntariei.utils.dateToString

class EventDetailsActivity : AppCompatActivity() {


    private var _binding : ActivityEventDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityEventDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val event: Event = intent.extras?.get(EVENT_ID) as Event

        binding.Back.setOnClickListener {
            finish()
        }

        event.let {
            binding.Nome.text = event.nome
            binding.Data.text = event.data.dateToString("dd/MM/yyyy")
            binding.Descricao.text = event.descricao
        }

    }
}