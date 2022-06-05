package com.facens.acedevelop.voluntariei.ui.mydata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.databinding.ActivityMyDataBinding
import com.facens.acedevelop.voluntariei.utils.LoadinDialog
import com.facens.acedevelop.voluntariei.utils.SharedPref
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyDataActivity : AppCompatActivity() {

    private var _binding: ActivityMyDataBinding? = null

    private val binding get() = _binding!!

    private val viewModel:MyDataViewModel by viewModels()

    private val shared = SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMyDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Back.setOnClickListener {
            finish()
        }


        binding.Enviar.setOnClickListener {
            if (!shared.getInstance(applicationContext).isOng) {
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
        LoadinDialog.displayLoadingWithText(this)
    }

    private fun config(){
        if (!shared.getInstance(applicationContext).isOng) {
                binding.Email.setText(shared.getInstance(applicationContext).email)
                binding.Nome.setText(shared.getInstance(applicationContext).nome)
                binding.Documento.setText(shared.getInstance(applicationContext).documento)
        }
        else{
            binding.Email.setText(shared.getInstance(applicationContext).email)
            binding.Nome.setText(shared.getInstance(applicationContext).nome)

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