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
import com.facens.acedevelop.voluntariei.databinding.ProfileFragmentBinding
import com.facens.acedevelop.voluntariei.ui.aboutapp.AboutActivity
import com.facens.acedevelop.voluntariei.ui.help.HelpActivity
import com.facens.acedevelop.voluntariei.ui.login.WelcomeActivity
import com.facens.acedevelop.voluntariei.ui.mydata.MyDataActivity
import com.facens.acedevelop.voluntariei.utils.SharedPref
import dagger.hilt.android.AndroidEntryPoint
import kotlin.system.exitProcess

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel: ProfileViewModel by viewModels()

    private var _binding : ProfileFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProfileFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.MyDataButton.setOnClickListener {
            startActivity(Intent(context,MyDataActivity::class.java))
        }

        binding.HelpButton.setOnClickListener {
            startActivity(Intent(context,HelpActivity::class.java))
        }

        binding.AboutAppButton.setOnClickListener {
            startActivity(Intent(context,AboutActivity::class.java))
        }

        binding.DeleteAccountButton.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Deseja realmente deletar sua conta ?")
            builder.setPositiveButton("Sim") { dialog, _ ->
                if (!SharedPref.getInstance(requireContext().applicationContext).isOng){
                    viewModel.deleteUser(SharedPref.getInstance(requireContext().applicationContext).id)
                    SharedPref.getInstance(requireContext().applicationContext).clearAll()
                    startActivity(Intent(context,WelcomeActivity::class.java))
                    finishAffinity(requireActivity().parent);
//                    exitProcess(0)
                }
                viewModel.deleteOng(SharedPref.getInstance(requireContext().applicationContext).id)
                startActivity(Intent(context,WelcomeActivity::class.java))
                SharedPref.getInstance(requireContext().applicationContext).clearAll()
                finishAffinity(requireActivity().parent);
            }
            builder.setNegativeButton("Não") { dialog, _ ->
                dialog.cancel()
            }
            builder.create()
            builder.show()
        }

        binding.QuitButton.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Deseja realmente sair de sua conta ?")
            builder.setPositiveButton("Sim") { dialog, _ ->
                SharedPref.getInstance(requireContext().applicationContext).clearAll()
                startActivity(Intent(context,WelcomeActivity::class.java))

            }
            builder.setNegativeButton("Não") { dialog, _ ->
                dialog.cancel()
            }
            builder.create()
            builder.show()
        }

    }

}