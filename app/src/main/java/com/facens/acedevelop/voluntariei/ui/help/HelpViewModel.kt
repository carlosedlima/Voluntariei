package com.facens.acedevelop.voluntariei.ui.help

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facens.acedevelop.voluntariei.domain.models.Help
import com.facens.acedevelop.voluntariei.domain.usecase.HelpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HelpViewModel @Inject constructor(
        private val helpUseCase: HelpUseCase
        ): ViewModel() {

    private val _helpList:MutableLiveData<List<Help>> = MutableLiveData()

    val helpList:LiveData<List<Help>> get() = _helpList

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> get() = _loading

    private val _error: MutableLiveData<String?> = MutableLiveData()
    val error: LiveData<String?> get() = _error

    fun getHelps()= viewModelScope.launch{
        _loading.postValue(true)
        try {
            val helps = helpUseCase.getHelps()
            _helpList.postValue(helps)
            _error.postValue(null)

        } catch (e : Exception){
            Log.e("HelpViewModel", e.toString())
            _error.postValue(e.message)

        } finally {
            _loading.postValue(false)
        }
    }

}