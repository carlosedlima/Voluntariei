package com.facens.acedevelop.voluntariei.ui.login.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facens.acedevelop.voluntariei.R
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.ONG
import com.facens.acedevelop.voluntariei.domain.models.User
import com.facens.acedevelop.voluntariei.domain.usecase.OngUseCase
import com.facens.acedevelop.voluntariei.domain.usecase.UsuarioUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val ongUseCase: OngUseCase,
    private val userUseCase: UsuarioUseCase,
): ViewModel()  {

    private val _userLogin = MutableLiveData<User?>()
    val userLogin: LiveData<User?> = _userLogin

    private val _ongLogged = MutableLiveData<ONG?>()
    val ongLogged: LiveData<ONG?> = _ongLogged

    private val _emailFieldErrorResId = MutableLiveData<Int>()
    val emailFieldErrorResId: LiveData<Int?> = _emailFieldErrorResId

    private val _passFieldErrorResId = MutableLiveData<Int>()
    val passFieldErrorResId: LiveData<Int?> = _passFieldErrorResId

    private var isFormValid = false

    fun loginUser(email:String,pass:String) = viewModelScope.launch{
        isFormValid =true

        _emailFieldErrorResId.value = getErrorStringResIdIfEmpty(email)
        _passFieldErrorResId.value = getErrorStringResIdIfEmpty(pass)

        if (isFormValid){
            try {
                val login = User(null, email = email, password = pass, name = "Teste", cpf = "47017867807")
                val valid = userUseCase.login(login)
                _userLogin.value = valid
            }catch (e: Exception){
                Log.d("LoginUser",e.toString())
            }
        }
    }

    fun loginOng(email:String,pass:String) = viewModelScope.launch{
        isFormValid =true

        _emailFieldErrorResId.value = getErrorStringResIdIfEmpty(email)
        _passFieldErrorResId.value = getErrorStringResIdIfEmpty(pass)

        if (isFormValid){
            try {
                    val login = LoginRequest(email,pass)
                    val valid = ongUseCase.login(login)
                    _ongLogged.value = valid
            }catch (e: Exception){
                Log.d("LoginOng",e.toString())
            }
        }
    }


    private fun getErrorStringResIdIfEmpty(value: String): Int? {
        return if (value.isEmpty()) {
            isFormValid = false
            R.string.field_error
        } else null
    }

}