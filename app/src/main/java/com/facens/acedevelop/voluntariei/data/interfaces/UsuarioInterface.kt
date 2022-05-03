package com.facens.acedevelop.voluntariei.data.interfaces

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface UsuarioInterface {

    @GET
    fun getUser()
    @DELETE
    fun deleteUser()
    @POST
    fun createUser()
    @PUT
    fun updateUser()


}