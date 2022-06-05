package com.facens.acedevelop.voluntariei.data.interfaces

import androidx.lifecycle.MutableLiveData
import com.facens.acedevelop.voluntariei.domain.models.LoginRequest
import com.facens.acedevelop.voluntariei.domain.models.LoginResponse
import com.facens.acedevelop.voluntariei.domain.models.ONG
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface OngInterface {

    @GET("/ongs/{id}")
    fun getOng(@Path("id")id:Int):Call<MutableLiveData<ONG>>

    @DELETE("/ongs/{id}")
    fun deleteOng(@Path("id")id:Int):Call<MutableLiveData<Boolean>>

    @POST("/ongs")
    fun createOng(@Body ong:ONG): Call<MutableLiveData<Boolean>>

    @PUT("/ongs/{id}")
    fun updateOng(@Path("id")id: Int):Call<MutableLiveData<ONG>>

    @POST("/ongs/login")
    fun loginOng(@Body login: LoginRequest):Call<ONG>
}