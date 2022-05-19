package com.facens.acedevelop.voluntariei.ui.home

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RecyclerPrincipal.adapter = EventsAdapter()
        binding.RecyclerPrincipal.layoutManager = LinearLayoutManager(context)
        vmEvents()

    }

    override fun onResume() {
        super.onResume()
        viewModel.getEvents()
    }
    private fun vmEvents(){
        viewModel.getEvent().observe(viewLifecycleOwner) {
            adapter.set(it)
        }
    }

    private fun config(){
        binding.Adicionar.isVisible = false
    }

}