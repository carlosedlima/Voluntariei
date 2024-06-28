package com.facens.acedevelop.voluntariei.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.databinding.ProfileFragmentBinding
import com.facens.acedevelop.voluntariei.ui.aboutapp.AboutActivity
import com.facens.acedevelop.voluntariei.ui.help.HelpActivity
import com.facens.acedevelop.voluntariei.ui.login.WelcomeActivity
import com.facens.acedevelop.voluntariei.ui.mydata.MyDataActivity
import com.facens.acedevelop.voluntariei.data.local.SharedPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel: ProfileViewModel by viewModels()

    private var _binding: ProfileFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sharedPref: SharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.MyDataButton.setOnClickListener {
            startActivity(Intent(context, MyDataActivity::class.java))
        }

        binding.HelpButton.setOnClickListener {
            startActivity(Intent(context, HelpActivity::class.java))
        }

        binding.AboutAppButton.setOnClickListener {
            startActivity(Intent(context, AboutActivity::class.java))
        }

        binding.DeleteAccountButton.setOnClickListener {
            val builder = AlertDialog.Builder(context)

            builder.setTitle(getString(R.string.confirmar_delete))

            builder.setPositiveButton(getString(R.string.sim)) { _, _ ->

                if (!sharedPref.isOng) {

                    viewModel.deleteUser(sharedPref.userId)
                    sharedPref.clearAll()
                    startActivity(Intent(context, WelcomeActivity::class.java))
                    finishAffinity(requireActivity().parent)

                }

                viewModel.deleteOng(sharedPref.userId)
                startActivity(Intent(context, WelcomeActivity::class.java))
                sharedPref.clearAll()
                finishAffinity(requireActivity().parent)

            }
            builder.setNegativeButton(getString(R.string.nao)) { dialog, _ ->

                dialog.cancel()

            }

            builder.create()
            builder.show()
        }

        binding.QuitButton.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.confirmar_saida))
            builder.setPositiveButton(getString(R.string.sim)) { _, _ ->
                sharedPref.clearAll()
                startActivity(Intent(context, WelcomeActivity::class.java))

            }
            builder.setNegativeButton(getString(R.string.nao)) { dialog, _ ->
                dialog.cancel()
            }
            builder.create()
            builder.show()
        }

    }

}