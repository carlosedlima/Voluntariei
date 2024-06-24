package com.facens.acedevelop.voluntariei.ui.help.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facens.acedevelop.voluntariei.databinding.ActivityHelpDetailsBinding
import com.facens.acedevelop.voluntariei.domain.models.Help
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.HELP_ID

class HelpDetailsActivity : AppCompatActivity() {
    private var _binding : ActivityHelpDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHelpDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val help: Help = intent.extras?.get(HELP_ID) as Help

        binding.Back.setOnClickListener {
            finish()
        }

        help.let {
            binding.Title.text = help.title
            binding.Description.text = help.description
        }

    }
}