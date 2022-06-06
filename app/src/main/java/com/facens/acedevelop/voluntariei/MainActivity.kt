package com.facens.acedevelop.voluntariei

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.facens.acedevelop.voluntariei.databinding.MainActivityBinding
import com.facens.acedevelop.voluntariei.domain.models.ONG
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.ui.home.HomeFragment
import com.facens.acedevelop.voluntariei.ui.profile.ProfileFragment
import com.facens.acedevelop.voluntariei.utils.Constantes
import com.facens.acedevelop.voluntariei.utils.SharedPref
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!

    private val sharedPref = SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mode: String = intent.extras?.get(Constantes.KEY.MODE).toString()

        if(sharedPref.getInstance(applicationContext).isFirstLogin){
            configShared(mode)
        }

        replaceFragment(HomeFragment())
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(HomeFragment())
                R.id.ic_profile -> replaceFragment(ProfileFragment())
            }
            true
        }

    }

    private fun configShared(mode:String){
        if (mode == "ONG"){
            val save:ONG = intent.extras?.get("Save") as ONG

            sharedPref.getInstance(applicationContext).saveEmail(save.email!!)
            sharedPref.getInstance(applicationContext).saveNome(save.name!!)
            sharedPref.getInstance(applicationContext).saveIsFirstLogin(false)
            sharedPref.getInstance(applicationContext).saveIsONG(true)
            sharedPref.getInstance(applicationContext).saveID(save.id!!)
        }else{
            val save:User = intent.extras?.get("Save") as User

            sharedPref.getInstance(applicationContext).saveDoc(save.cpf)
            sharedPref.getInstance(applicationContext).saveEmail(save.email)
            sharedPref.getInstance(applicationContext).saveNome(save.name)
            sharedPref.getInstance(applicationContext).saveID(save.id!!)
            sharedPref.getInstance(applicationContext).saveIsFirstLogin(false)
        }

    }
    private fun replaceFragment(fragment: Fragment) : FragmentTransaction =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }

}