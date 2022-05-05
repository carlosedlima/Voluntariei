package com.facens.acedevelop.voluntariei.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)



    }
}