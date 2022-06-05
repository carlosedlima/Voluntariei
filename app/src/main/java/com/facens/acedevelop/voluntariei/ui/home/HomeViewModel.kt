package com.facens.acedevelop.voluntariei.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facens.acedevelop.voluntariei.domain.models.Evento
import com.facens.acedevelop.voluntariei.domain.usecase.EventoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val eventoUseCase: EventoUseCase
): ViewModel() {

    private val eventoList: MutableLiveData<List<Evento>> = MutableLiveData<List<Evento>>()
    fun getEvent(): LiveData<List<Evento>> = eventoList


    fun getEvents()= viewModelScope.launch{
        try {
            val events = eventoUseCase.getEvents()
            eventoList.value = events
        }catch (e:Exception){
            Log.e("EventoViewModel",e.toString())
        }
    }
}