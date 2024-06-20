package com.facens.acedevelop.voluntariei.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facens.acedevelop.voluntariei.domain.models.Event
import com.facens.acedevelop.voluntariei.domain.usecase.EventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val eventUseCase: EventUseCase
): ViewModel() {

    private val eventList: MutableLiveData<List<Event>> = MutableLiveData<List<Event>>()
    fun getEvent(): LiveData<List<Event>> = eventList


    fun getEvents()= viewModelScope.launch{
        try {
            val events = eventUseCase.getEvents()
            eventList.value = events
        }catch (e:Exception){
            Log.e("EventoViewModel",e.toString())
        }
    }
}