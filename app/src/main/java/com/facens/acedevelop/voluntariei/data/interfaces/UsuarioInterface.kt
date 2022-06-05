package com.facens.acedevelop.voluntariei.data.interfaces

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.LoginResponse
import com.facens.acedevelop.voluntariei.domain.models.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface UsuarioInterface {

    @GET("/users/{id}")
    fun getUser(@Path("id")id:Int):Call<MutableLiveData<User>>
    @DELETE("/users/{id}")
    fun deleteUser(@Path("id")id:Int):Call<MutableLiveData<Boolean>>
    @POST("/users")
    fun createUser(@Body user: User): Call<MutableLiveData<Boolean>>
    @PUT("/users/{id}")
    fun updateUser(@Path("id")id: Int):Call<MutableLiveData<User>>
    @POST("/users/login")
    fun loginUser(@Body login: LoginRequest):Call<User?>

}