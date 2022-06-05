package com.facens.acedevelop.voluntariei.ui.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.domain.usecase.OngUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.UsuarioUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val ongUseCase: OngUseCase,
    private val userUseCase: UsuarioUseCase,
): ViewModel() {

    public fun deleteUser(id:Int)=viewModelScope.launch{
        try {
            userUseCase.deleteUser(id)
        }catch (e: Exception){
            Log.d("RegisterUser",e.toString())
        }
    }

    public fun deleteOng(id:Int)=viewModelScope.launch{
        try {
            ongUseCase.deleteOng(id)
        }catch (e: Exception){
            Log.d("RegisterUser",e.toString())
        }
    }

}