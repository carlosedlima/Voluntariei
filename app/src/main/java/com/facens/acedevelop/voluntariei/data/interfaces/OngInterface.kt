package com.facens.acedevelop.voluntariei.data.interfaces

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface OngInterface {

    @GET
    fun getOng()
    @DELETE
    fun deleteOng()
    @POST
    fun createOng()
    @PUT
    fun updateOng()
}