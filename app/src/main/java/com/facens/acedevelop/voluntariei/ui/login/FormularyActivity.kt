package com.facens.acedevelop.voluntariei.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.databinding.ActivityFormularyBinding
import com.facens.acedevelop.voluntariei.ui.login.viewmodels.RegisterViewModel
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.MODE
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.ONG
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormularyActivity : AppCompatActivity() {

    private var _binding: ActivityFormularyBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFormularyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mode: String = intent.extras?.get(MODE).toString()

        configScreen(mode)
        observerVMEvents()
    }

    private fun configScreen(mode: String) {
        if (mode == ONG) {
            binding.DocumentoLayout.setHint(R.string.CNPJ)
            binding.NomeLayout.setHint(R.string.NameOng)
            binding.Cadastrar.setOnClickListener {

                val name = binding.Nome.text.toString()
                val email = binding.Email.text.toString()
                val pass = binding.Senha.text.toString()


                viewModel.createOng(name,email,pass)

            }
        } else {
            binding.DocumentoLayout.setHint(R.string.CPF)
            binding.NomeLayout.setHint(R.string.Name)
            binding.Cadastrar.setOnClickListener {

                val name = binding.Nome.text.toString()
                val email = binding.Email.text.toString()
                val document = binding.Documento.text.toString()
                val pass = binding.Senha.text.toString()


                viewModel.createUser(name,email,pass,document)

            }
        }
    }

    private fun observerVMEvents() {
        viewModel.documentFieldErrorResId.observe(this) { stringResId ->
            binding.DocumentoLayout.setError(stringResId)
        }

        viewModel.emailFieldErrorResId.observe(this) { stringResId ->
            binding.EmailLayout.setError(stringResId)
        }
        viewModel.nameFieldErrorResId.observe(this) { stringResId ->
            binding.NomeLayout.setError(stringResId)
        }
        viewModel.passFieldErrorResId.observe(this) { stringResId ->
            binding.SenhaLayout.setError(stringResId)
        }
        viewModel.documentFieldErrorResId.observe(this) { stringResId ->
            binding.ConfirmarLayout.setError(stringResId)
        }
    }


    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }
}