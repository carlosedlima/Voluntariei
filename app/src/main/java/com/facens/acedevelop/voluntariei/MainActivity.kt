package com.facens.acedevelop.voluntariei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.facens.acedevelop.voluntariei.databinding.MainActivityBinding
import com.facens.acedevelop.voluntariei.domain.models.Ong
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.ui.home.HomeFragment
import com.facens.acedevelop.voluntariei.ui.profile.ProfileFragment
import com.facens.acedevelop.voluntariei.utils.Constantes
import com.facens.acedevelop.voluntariei.data.local.SharedPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mode: String = intent.extras?.get(Constantes.KEY.MODE).toString()

        if(sharedPref.isFirstLogin){
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
            val save:Ong = intent.extras?.get("Save") as Ong

            sharedPref.saveEmail(save.email!!)
            sharedPref.saveNome(save.name!!)
            sharedPref.saveIsFirstLogin(false)
            sharedPref.saveIsOng(true)
            sharedPref.saveUserId(save.id!!)
        }else{
            val save:User = intent.extras?.get("Save") as User

            sharedPref.saveDocument(save.cpf)
            sharedPref.saveEmail(save.email)
            sharedPref.saveNome(save.name)
            sharedPref.saveUserId(save.id!!)
            sharedPref.saveIsFirstLogin(false)
        }

    }
    private fun replaceFragment(fragment: Fragment) : FragmentTransaction =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }

}