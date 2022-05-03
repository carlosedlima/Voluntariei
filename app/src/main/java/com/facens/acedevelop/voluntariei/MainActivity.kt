package com.facens.acedevelop.voluntariei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.facens.acedevelop.voluntariei.databinding.MainActivityBinding
import com.facens.acedevelop.voluntariei.ui.home.HomeFragment
import com.facens.acedevelop.voluntariei.ui.notifications.NotificationFragment
import com.facens.acedevelop.voluntariei.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())


        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(HomeFragment())
                R.id.ic_notification -> replaceFragment(NotificationFragment())
                R.id.ic_profile -> replaceFragment(ProfileFragment())
            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment) : FragmentTransaction =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }

}