package com.facens.acedevelop.voluntariei.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.facens.acedevelop.voluntariei.MainActivity
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.databinding.ActivityLoginActivtyBinding
import com.facens.acedevelop.voluntariei.ui.login.bottomsheet.BottomSheetFragment
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.ONG

class LoginActivty : AppCompatActivity() {

    private var MODE = "MODO"

    private var _binding: ActivityLoginActivtyBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mode:String = intent.hasExtra(MODE).toString()

        configLogin(mode)
        binding.LoginEmail.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        binding.MoreOptions.setOnClickListener {
            val bottomSheet = BottomSheetFragment()
            bottomSheet.show(supportFragmentManager,"BottomSheetDialog")
        }

        binding.Cadastrar.setOnClickListener {

        }

    }

    private fun configLogin(mode:String){
        if (mode == ONG){
            binding.MoreOptions.isVisible = false
        }
    }

}