package com.facens.acedevelop.voluntariei.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.facens.acedevelop.voluntariei.MainActivity
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.databinding.ActivityLoginBinding
import com.facens.acedevelop.voluntariei.domain.models.Ong
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.ui.login.viewmodels.LoginViewModel
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.MODE
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.ONG
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.SAVE
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.USER
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mode: String = intent.extras?.get(MODE).toString()

        configTela(mode)
        observeVMEvents()
    }

    private fun configTela(mode: String) {
        binding.Logar.setOnClickListener {
            val email = binding.Email.text.toString()
            val pass = binding.Senha.text.toString()

            if (mode == ONG) {
                viewModel.loginOng(email, pass)
            } else {
                viewModel.loginUser(email, pass)
            }
        }
    }

    private fun observeVMEvents() {
        viewModel.emailFieldErrorResId.observe(this) { stringResId ->
            binding.EmailLayout.setError(stringResId)
        }

        viewModel.passFieldErrorResId.observe(this) { stringResId ->
            binding.SenhaLayout.setError(stringResId)
        }

        viewModel.userLogin.observe(this) { user ->
            user?.let {
                navigateToMainScreen(USER, it)
            } ?: run {
                Toast.makeText(this, getString(R.string.email_ou_senha_invalido), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.ongLogged.observe(this) { ong ->
            ong?.let {
                navigateToMainScreen(ONG, it)
            } ?: run {
                Toast.makeText(this, getString(R.string.email_ou_senha_invalido), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loginError.observe(this) { errorMessage ->
            errorMessage?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMainScreen(mode: String, entity: Any) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(MODE, mode)
            putExtra(SAVE, entity as Serializable)
        }
        Toast.makeText(this,getString(R.string.bem_vindo),Toast.LENGTH_SHORT).show()
        startActivity(intent)
        finish()
    }


    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }
}