package com.facens.acedevelop.voluntariei.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.facens.acedevelop.voluntariei.databinding.MainFragmentBinding
import com.facens.acedevelop.voluntariei.ui.home.adapter.EventsAdapter
import com.facens.acedevelop.voluntariei.ui.home.bottomsheet.BottomSheetFragment
import com.facens.acedevelop.voluntariei.ui.login.WelcomeActivity
import com.facens.acedevelop.voluntariei.utils.LoadingDialog
import com.facens.acedevelop.voluntariei.utils.SharedPref
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var _binding : MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val adapter = EventsAdapter()
    private val shared = SharedPref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RecyclerPrincipal.adapter = adapter
        binding.RecyclerPrincipal.layoutManager = LinearLayoutManager(context)
        vmEvents()
        config()
        binding.Adicionar.setOnClickListener {
            val bottomSheet = BottomSheetFragment()
            bottomSheet.show(parentFragmentManager,"BottomSheetDialog")
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getEvents()
        LoadingDialog.startLoadingDialog(requireContext())
    }
    private fun vmEvents(){
        viewModel.getEvent().observe(viewLifecycleOwner) {
            LoadingDialog.dismissDialog()
            adapter.set(it)
        }
    }

    private fun config(){
        binding.Adicionar.isVisible = shared.getInstance(requireContext()).isOng
    }

}