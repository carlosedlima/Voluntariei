package com.facens.acedevelop.voluntariei.ui.home.bottomsheet

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.facens.acedevelop.voluntariei.databinding.BottomsheetMoreOptionsBinding
import com.facens.acedevelop.voluntariei.utils.SharedPref
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

@AndroidEntryPoint
class BottomSheetFragment : BottomSheetDialogFragment(){

    private var _binding: BottomsheetMoreOptionsBinding? = null
    private val binding get() = _binding!!
    private val viewModel:BottomSheetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomsheetMoreOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.DataButton.setOnClickListener {

            datePickerCall()
        }

        binding.BotaoRegistrar.setOnClickListener {
            val nome = binding.NomeEvent.text.toString()
            val descricao = binding.Description.text.toString()
            val id  = SharedPref.getInstance(requireContext().applicationContext).userId
            val dateString = binding.DataButton.text.toString()
            val date = stringToDate(dateString)
            if (date != null) {
                viewModel.registerEvento(nome,descricao,date,id!!)
            }
        }

        vmEvents()
        todayDate()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun datePickerCall() {
        val datePicker = DatePickerDialog(requireContext())

        datePicker.setOnDateSetListener { _, ano, mes, dia ->
            run {
                val mes = mes + 1
                val date: String = makeDateString(dia, mes, ano)
                binding.DataButton.text = date
            }
        }

        datePicker.show()
    }

    private fun todayDate(){
        val cal:Calendar = Calendar.getInstance()
        val dia:Int = cal.get(Calendar.DAY_OF_MONTH)
        val mes:Int = cal.get(Calendar.MONTH)
        val ano:Int = cal.get(Calendar.YEAR)
        binding.DataButton.text = makeDateString(dia,mes,ano)
    }
    private fun stringToDate(dateString:String): Date? {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val date = formatter.parse(dateString)
        return date
    }

    private fun vmEvents(){
        viewModel.nameFieldErrorResId.observe(this) { stringResId ->
            binding.NomeEventLayout.setError(stringResId)
        }

        viewModel.descricaoFieldErrorResId.observe(this) { stringResId ->
            binding.DescriptionLayout.setError(stringResId)
        }
    }

    private fun TextInputLayout.setError(stringResId: Int?) {
        error = if (stringResId != null) {
            getString(stringResId)
        } else null
    }
    private fun makeDateString(dia:Int,mes:Int,ano:Int): String{
        return "${dia}/${mes}/${ano}"
    }

}