package com.facens.acedevelop.voluntariei.ui.mydata

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.facens.acedevelop.voluntariei.databinding.ActivityMyDataBinding
import com.facens.acedevelop.voluntariei.data.local.SharedPref
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyDataActivity : AppCompatActivity() {

    private var _binding: ActivityMyDataBinding? = null

    private val binding get() = _binding!!

    private val viewModel:MyDataViewModel by viewModels()

    @Inject
    lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMyDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Back.setOnClickListener {
            finish()
        }


        binding.Enviar.setOnClickListener {
            if (!sharedPref.isOng) {
                val email = binding.Email.text.toString()
                val nome = binding.Nome.text.toString()
                val document = binding.Documento.text.toString()
                val pass = binding.ConfirmarSenha.text.toString()
                viewModel.updateUser(nome,email,document,pass)
            }
            else{
                val email = binding.Email.text.toString()
                val nome = binding.Nome.text.toString()
                val pass = binding.ConfirmarSenha.text.toString()
                viewModel.upsdateOng(nome,email,pass)
            }
        }

        observerVMEvents()
        config()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun config(){
        if (!sharedPref.isOng) {
                binding.Email.setText(sharedPref.email)
                binding.Nome.setText(sharedPref.nome)
                binding.Documento.setText(sharedPref.documento)
        }
        else{
            binding.Email.setText(sharedPref.email)
            binding.Nome.setText(sharedPref.nome)
            binding.DocumentoLayout.isGone = true
            binding.Documento.isGone = true
        }
    }

    private fun observerVMEvents() {

        viewModel.emailFieldErrorResId.observe(this) { stringResId ->
            binding.EmailLayout.setError(stringResId)
        }

        viewModel.nameFieldErrorResId.observe(this) { stringResId ->
            binding.NomeLayout.setError(stringResId)
        }

        viewModel.passFieldErrorResId.observe(this) { stringResId ->
            binding.SenhaLayout.setError(stringResId)
        }

        viewModel.passFieldErrorResId.observe(this) { stringResId ->
            binding.ConfirmarLayout.setError(stringResId)
        }
    }

    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }
}