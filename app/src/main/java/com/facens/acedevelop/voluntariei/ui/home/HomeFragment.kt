package com.facens.acedevelop.voluntariei.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.facens.acedevelop.voluntariei.databinding.MainFragmentBinding
import com.facens.acedevelop.voluntariei.ui.home.adapter.EventsAdapter
import com.facens.acedevelop.voluntariei.ui.bottomsheet.BottomSheetFragment
import com.facens.acedevelop.voluntariei.utils.LoadingDialog
import com.facens.acedevelop.voluntariei.data.local.SharedPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var _binding : MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: EventsAdapter

    @Inject
    lateinit var sharedPref: SharedPref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = EventsAdapter(requireContext())

        binding.RecyclerPrincipal.adapter = adapter
        binding.RecyclerPrincipal.layoutManager = LinearLayoutManager(context)
        vmEvents()
        config()

    }

    override fun onResume() {
        super.onResume()
        viewModel.getEvents()
    }
    private fun vmEvents() {
        viewModel.eventList.observe(viewLifecycleOwner) { events ->
            adapter.set(events)
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                LoadingDialog.startLoadingDialog(requireContext())
            } else {
                LoadingDialog.dismissDialog()
            }
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            if (errorMessage != null) {
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun config(){
        binding.Adicionar.isVisible = sharedPref.isOng
        binding.Adicionar.setOnClickListener {
            val bottomSheet = BottomSheetFragment()
            bottomSheet.show(parentFragmentManager,"BottomSheetDialog")
        }
    }

}