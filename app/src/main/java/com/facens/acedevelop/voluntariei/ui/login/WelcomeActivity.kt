package com.facens.acedevelop.voluntariei.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facens.acedevelop.voluntariei.databinding.ActivityWelcomeBinding
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.MODE
import com.facens.acedevelop.voluntariei.utils.Constantes.KEY.ONG

class WelcomeActivity : AppCompatActivity() {
    private var _binding: ActivityWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginOng.setOnClickListener {
            val i = Intent(this,LoginActivty::class.java)
            i.putExtra(MODE, ONG)
            startActivity(i)
        }

        binding.LoginUser.setOnClickListener {
            val i = Intent(this,LoginActivty::class.java)
            startActivity(i)
        }

    }

}