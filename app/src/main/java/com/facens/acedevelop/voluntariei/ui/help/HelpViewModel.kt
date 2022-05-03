package com.facens.acedevelop.voluntariei.ui.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facens.acedevelop.voluntariei.data.di.Request
import com.facens.acedevelop.voluntariei.data.interfaces.HelpInterface
import com.facens.acedevelop.voluntariei.domain.models.Help
import com.facens.acedevelop.voluntariei.utils.listen

class HelpViewModel : ViewModel() {

    private val helpList:MutableLiveData<List<Help>> = MutableLiveData<List<Help>>()
    fun getHelp(): LiveData<List<Help>> = helpList


     fun getHelps(){
        Request.create(HelpInterface::class.java).getHelps().listen(
            onSuccess = { response ->
            if (response.isSuccessful){
                helpList.postValue(response.body())
            }
        },
            onError = {

        })
    }

}