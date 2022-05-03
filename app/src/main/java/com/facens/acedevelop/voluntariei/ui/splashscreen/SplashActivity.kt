package com.facens.acedevelop.voluntariei.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facens.acedevelop.voluntariei.MainActivity
import com.facens.acedevelop.voluntariei.databinding.ActivitySplashBinding
import com.facens.acedevelop.voluntariei.ui.login.WelcomeActivity

class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.LogoSplash.alpha = 0f
        binding.LogoSplash.animate().setDuration(1500).alpha(1f).withEndAction {
            val i = Intent(this,WelcomeActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }


    }

}