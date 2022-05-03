package com.facens.acedevelop.voluntariei.ui.aboutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facens.acedevelop.voluntariei.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private var _binding: ActivityAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Back.setOnClickListener {
            finish()
        }

    }
}