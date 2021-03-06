package com.facens.acedevelop.voluntariei.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import com.facens.acedevelop.voluntariei.MainActivity
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.databinding.ActivityModeBinding
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.MODE
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.ONG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModeActivity : AppCompatActivity() {

    private var _binding: ActivityModeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mode:String = intent.extras?.get(MODE).toString()

        configLogin(mode)

    }

    private fun configLogin(mode:String){
        if (mode == ONG){
            binding.LoginEmail.setOnClickListener {
                val i = Intent(this, LoginActivity::class.java)
                i.putExtra(MODE,mode)
                startActivity(i)
            }
            binding.Cadastrar.setOnClickListener {
                val i = Intent(this, FormularyActivity::class.java)
                i.putExtra(MODE,mode)
                startActivity(i)
            }
        }
        else
        {
            binding.LoginEmail.setOnClickListener {
                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            }

            binding.Cadastrar.setOnClickListener {
                val i = Intent(this, FormularyActivity::class.java)
                i.putExtra(MODE,mode)
                startActivity(i)
            }
        }
    }

}