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

    private val helpList:MutableLiveData<List<Help>> = MutableLiveData<List<Help>>()
    fun getHelp(): LiveData<List<Help>> = helpList


    fun getHelps()= viewModelScope.launch{
        try {
            val helps = helpUseCase.getHelps()
            helpList.value = helps
        }catch (e:Exception){
            Log.d("HelpViewModel",e.toString())
        }
    }

}