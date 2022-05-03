package com.facens.acedevelop.voluntariei.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.facens.acedevelop.voluntariei.databinding.ProfileFragmentBinding
import com.facens.acedevelop.voluntariei.ui.aboutapp.AboutActivity
import com.facens.acedevelop.voluntariei.ui.help.HelpActivity
import com.facens.acedevelop.voluntariei.ui.mydata.MyDataActivity

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

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
            var builder = AlertDialog.Builder(context)
            builder.setTitle("Deseja realmente deletar sua conta ?")
            builder.setPositiveButton("Sim") { dialog, _ ->
                dialog.cancel()
            }
            builder.setNegativeButton("Não") { dialog, _ ->
                dialog.cancel()
            }
            builder.create()
            builder.show()
        }

        binding.QuitButton.setOnClickListener {
            var builder = AlertDialog.Builder(context)
            builder.setTitle("Deseja realmente deletar sua conta ?")
            builder.setPositiveButton("Sim") { dialog, _ ->
                dialog.cancel()
            }
            builder.setNegativeButton("Não") { dialog, _ ->
                dialog.cancel()
            }
            builder.create()
            builder.show()
        }

    }

}