package com.facens.acedevelop.voluntariei.ui.login.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.domain.models.ONG
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.domain.usecase.OngUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.UsuarioUseCase
import com.facens.acedevelop.voluntariei.utils.isCPF
import com.facens.acedevelop.voluntariei.utils.isEmail
import com.facens.acedevelop.voluntariei.utils.isName
import com.facens.acedevelop.voluntariei.utils.isPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val ongUseCase: OngUseCase,
    private val userUseCase:UsuarioUseCase,
) : ViewModel() {

    private val _errorRegisterOng = MutableLiveData<Int>()
    val errorRegisterOng: LiveData<Int?> = _errorRegisterOng

    private val _errorRegisterUser = MutableLiveData<Int>()
    val errorRegisterUser: LiveData<Int?> = _errorRegisterUser

    private val _nameFieldErrorResId = MutableLiveData<Int>()
    val nameFieldErrorResId: LiveData<Int?> = _nameFieldErrorResId

    private val _emailFieldErrorResId = MutableLiveData<Int>()
    val emailFieldErrorResId: LiveData<Int?> = _emailFieldErrorResId

    private val _passFieldErrorResId = MutableLiveData<Int>()
    val passFieldErrorResId: LiveData<Int?> = _passFieldErrorResId

    private val _documentFieldErrorResId = MutableLiveData<Int>()
    val documentFieldErrorResId: LiveData<Int?> = _documentFieldErrorResId


    private val _userCreated = MutableLiveData<User>()
    val userCreated: LiveData<User> = _userCreated

    private val _ongCreated = MutableLiveData<ONG>()
    val ongCreated: LiveData<ONG> = _ongCreated

    private var isFormValid = false

    fun createUser(name:String,email:String,pass:String,document:String)=viewModelScope.launch {
        isFormValid =true

        _nameFieldErrorResId.value = getErrorStringResIdIfEmpty(name)
        _documentFieldErrorResId.value = getErrorStringResIdIfEmpty(document)
        _emailFieldErrorResId.value = getErrorStringResIdIfEmpty(email)
        _passFieldErrorResId.value = getErrorStringResIdIfEmpty(pass)

        if (isFormValid){
            try {
                val user = userUseCase.registerUser(User(null,name,email,pass,document))
                _userCreated.value = user
            }catch (e:Exception){
                Log.d("RegisterUser",e.toString())
            }
        }
    }

    fun createOng(name:String,email:String,pass:String)=viewModelScope.launch {
        isFormValid =true

        _nameFieldErrorResId.value = getErrorStringResIdIfEmpty(name)
        _emailFieldErrorResId.value = getErrorStringResIdIfEmpty(email)
        _passFieldErrorResId.value = getErrorStringResIdIfEmpty(pass)

        if (isFormValid){
            try {
                val ong = ongUseCase.registerOng(ONG(1,name,email,pass))
                _ongCreated.value = ong
            }catch (e:Exception){
                Log.d("RegisterUser",e.toString())
            }
        }
    }


    private fun getErrorStringResIdIfEmpty(value: String): Int? {
        return if (value.isEmpty()) {
            isFormValid = false
            R.string.field_error
        } else null
    }

    private fun getErrorStringResIdIfIsNotEmail(value:String):Int?{
        return if (!value.isEmail){
            R.string.field_error
        }else null

    }

    private fun getErrorStringResIdIfIsNotPass(value:String):Int?{
        return if (!value.isPassword) {
            isFormValid = false
            R.string.field_error
        }else null

    }

    private fun getErrorStringResIdIfIsNotName(value:String):Int?{
        return if (!value.isName){
            isFormValid = false
            R.string.field_error
        }else null

    }

    private fun getErrorStringResIdIfIsNotDocument(value:String):Int?{
        return if (!value.isCPF) {
            isFormValid = false
            R.string.field_error
        }else null

    }

}