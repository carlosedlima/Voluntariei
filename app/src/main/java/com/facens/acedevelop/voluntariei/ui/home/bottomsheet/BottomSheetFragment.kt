package com.facens.acedevelop.voluntariei.ui.home.bottomsheet

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.facens.acedevelop.voluntariei.databinding.BottomsheetMoreOptionsBinding
import com.facens.acedevelop.voluntariei.utils.SharedPref
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

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

            val datePicker = DatePickerDialog(requireContext())

            datePicker.setOnDateSetListener(DatePickerDialog.OnDateSetListener { _, ano, mes, dia ->
                run {
                    var mes = mes + 1
                    var date: String = makeDateString(dia, mes, ano)
                    binding.DataButton.setText(date)
                }
            })

            var cal:Calendar = Calendar.getInstance()
            var dia:Int = cal.get(Calendar.DAY_OF_MONTH)
            var mes:Int = cal.get(Calendar.MONTH)
            var ano:Int = cal.get(Calendar.YEAR)

            datePicker.show()
        }

        binding.BotaoRegistrar.setOnClickListener {
            val nome = binding.NomeEvent.text.toString()
            val descricao = binding.Description.text.toString()
            val id  = SharedPref.getInstance(requireContext().applicationContext).id
            val dateString = binding.DataButton.text.toString()
            val date = stringToDate(dateString)
            viewModel.registerEvento(nome,descricao,date,id)
        }

        vmEvents()

    }

    fun stringToDate(dateString:String):Date {
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