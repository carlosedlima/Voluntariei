package com.facens.acedevelop.voluntariei.ui.help

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.facens.acedevelop.voluntariei.databinding.ActivityHelpBinding
import com.facens.acedevelop.voluntariei.ui.help.adapter.HelpAdapter
import com.facens.acedevelop.voluntariei.utils.LoadingDialog
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
        vmEvents()

    }

    private fun vmEvents() {
        viewmodel.helpList.observe(this) {
            adapter.set(it)
        }

        viewmodel.loading.observe(this){isLoading ->
            if (isLoading) {
                LoadingDialog.startLoadingDialog(this)
            } else {
                LoadingDialog.dismissDialog()
            }
        }

        viewmodel.error.observe(this) { errorMessage ->
            if (errorMessage != null) {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewmodel.getHelps()
    }



}