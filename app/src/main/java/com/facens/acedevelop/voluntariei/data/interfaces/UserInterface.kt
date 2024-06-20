package com.facens.acedevelop.voluntariei.data.interfaces

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.User
import retrofit2.Call
import retrofit2.http.*

interface UserInterface {

    @GET("/user/{id}")
    fun getUser(@Path("id")id:Int):Call<MutableLiveData<User>>
    @DELETE("/user/{id}")
    fun deleteUser(@Path("id")id:Int):Call<MutableLiveData<Boolean>>
    @POST("/user")
    fun createUser(@Body user: User): Call<MutableLiveData<Boolean>>
    @PUT("/user/{id}")
    fun updateUser(@Path("id")id: Int):Call<MutableLiveData<User>>
    @POST("/user/login")
    fun loginUser(@Body login:LoginRequest):Call<User?>

}