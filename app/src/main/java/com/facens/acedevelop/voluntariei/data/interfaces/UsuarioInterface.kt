package com.facens.acedevelop.voluntariei.data.interfaces

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.User
import retrofit2.Call
import retrofit2.http.*

interface UsuarioInterface {

    @GET("/ong/{id}")
    fun getUser(@Path("id")id:Int):Call<MutableLiveData<User>>
    @DELETE("/ong/{id}")
    fun deleteUser(@Path("id")id:Int):Call<MutableLiveData<Boolean>>
    @POST("/ong")
    fun createUser(user: User): Call<MutableLiveData<Boolean>>
    @PUT("/ong/{id}")
    fun updateUser(@Path("id")id: Int):Call<MutableLiveData<User>>


}