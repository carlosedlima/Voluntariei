package com.facens.acedevelop.voluntariei.ui.home.bottomsheet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.domain.models.Evento
import com.facens.acedevelop.voluntariei.domain.usecase.EventoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BottomSheetViewModel @Inject constructor(
    val eventoUseCase: EventoUseCase
): ViewModel() {

    private val _nameFieldErrorResId = MutableLiveData<Int>()
    val nameFieldErrorResId: LiveData<Int?> = _nameFieldErrorResId

    private val _descricaoFieldErrorResId = MutableLiveData<Int>()
    val descricaoFieldErrorResId: LiveData<Int?> = _descricaoFieldErrorResId

    private val _dataFieldErrorResId = MutableLiveData<Int>()
    val dataFieldErrorResId: LiveData<Int?> = _dataFieldErrorResId



    private var isFormValid = false

     fun registerEvento(nome:String,descricao:String,data:Date,idOng:Int)= viewModelScope.launch {
         isFormValid = true

         _nameFieldErrorResId.value = getErrorStringResIdIfEmpty(nome)
         _descricaoFieldErrorResId.value = getErrorStringResIdIfEmpty(descricao)
         _dataFieldErrorResId.value = getErrorDateResIdIfEmpty(data)

         if (isFormValid){
             try {
                val event = Evento(0,nome,descricao,data,idOng)
                 eventoUseCase.createEvent(event)
             }catch (e:Exception){
                 Log.d("BottomSheetViewModel",e.toString())
             }
         }

     }
    private fun getErrorStringResIdIfEmpty(value: String): Int? {
        return if (value.isEmpty()) {
            isFormValid = false
            R.string.field_error
        } else null
    }
    private fun getErrorDateResIdIfEmpty(value: Date): Int? {
        return if (value.equals("")) {
            isFormValid = false
            R.string.field_error
        } else null
    }
}