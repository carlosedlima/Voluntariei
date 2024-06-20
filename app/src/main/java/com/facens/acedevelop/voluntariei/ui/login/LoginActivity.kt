package com.facens.acedevelop.voluntariei.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.facens.acedevelop.voluntariei.MainActivity
import com.facens.acedevelop.voluntariei.databinding.ActivityLoginBinding
import com.facens.acedevelop.voluntariei.domain.models.Ong
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.ui.login.viewmodels.LoginViewModel
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.MODE
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.ONG
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.USER
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

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
        obserVMEvents()

    }

    private fun configTela(mode:String){
        if (mode == ONG){
            binding.Logar.setOnClickListener {
                val email = binding.Email.text.toString()
                val pass = binding.Senha.text.toString()

                viewModel.loginOng(email, pass)
            }
        }
        else
            binding.Logar.setOnClickListener {
                val email = binding.Email.text.toString()
                val pass = binding.Senha.text.toString()

                viewModel.loginUser(email, pass)
            }
    }

    private fun obserVMEvents(){
        viewModel.emailFieldErrorResId.observe(this) { stringResId ->
            binding.EmailLayout.setError(stringResId)
        }
        viewModel.passFieldErrorResId.observe(this) { stringResId ->
            binding.SenhaLayout.setError(stringResId)
        }

        viewModel.userLogin.observe(this){ result ->
            val user: User? = result
            if (user != null){
                Toast.makeText(this,"Sucesso",Toast.LENGTH_SHORT).show()
                val i = Intent(this, MainActivity::class.java)
                i.putExtra(MODE, USER)
                i.putExtra("Save",user)
                startActivity(i)
            }else{
                Toast.makeText(this,"Email ou senha invalido",Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.ongLogged.observe(this){ result ->
            val ong: Ong? = result
            if (ong != null){
                Toast.makeText(this,"Sucesso",Toast.LENGTH_SHORT).show()
                val i = Intent(this, MainActivity::class.java)
                i.putExtra(MODE, ONG)
                i.putExtra("Save",ong)
                startActivity(i)
            }else{
                Toast.makeText(this,"Email ou senha invalidó",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }
}