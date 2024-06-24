package com.facens.acedevelop.voluntariei.ui.help

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.facens.acedevelop.voluntariei.databinding.ActivityHelpBinding
import com.facens.acedevelop.voluntariei.ui.help.adapter.HelpAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HelpActivity : AppCompatActivity() {

    private var _binding: ActivityHelpBinding? = null
    private val binding get() = _binding!!
    private val viewmodel:HelpViewModel by viewModels()
    lateinit var adapter: HelpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = HelpAdapter(applicationContext)
        binding.Back.setOnClickListener {
            finish()
        }

        binding.RecycleHelps.adapter = adapter
        binding.RecycleHelps.layoutManager = LinearLayoutManager(this)
        viewmodel.getHelp().observe(this) {
            adapter.set(it)
        }

    }

    override fun onResume() {
        super.onResume()
        viewmodel.getHelps()
    }



}