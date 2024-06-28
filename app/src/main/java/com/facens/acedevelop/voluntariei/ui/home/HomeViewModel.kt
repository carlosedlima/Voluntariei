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

    private val _eventList: MutableLiveData<List<Event>> = MutableLiveData()
    val eventList: LiveData<List<Event>> get() = _eventList

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> get() = _loading

    private val _error: MutableLiveData<String?> = MutableLiveData()
    val error: LiveData<String?> get() = _error

    fun getEvents()= viewModelScope.launch{
        _loading.postValue(true)
        try {
            val events = eventUseCase.getEvents()
            _eventList.postValue(events)
            _error.postValue(null)
        } catch (e: Exception) {
            Log.e("HomeViewModel", e.toString())
            _error.postValue(e.message)
        } finally {
            _loading.postValue(false)
        }
    }
}