package com.facens.acedevelop.voluntariei.data.services

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET("/user/{id}")
    fun getUser(@Path("id")id:Long):Call<MutableLiveData<User>>
    @DELETE("/user/{id}")
    fun deleteUser(@Path("id")id:Long):Call<MutableLiveData<Boolean>>
    @POST("/user")
    fun createUser(@Body user: User): Call<MutableLiveData<Boolean>>
    @PUT("/user/{id}")
    fun updateUser(@Path("id")id: Long):Call<MutableLiveData<User>>
    @POST("/user/login")
    fun loginUser(@Body login:LoginRequest):Call<User?>

}