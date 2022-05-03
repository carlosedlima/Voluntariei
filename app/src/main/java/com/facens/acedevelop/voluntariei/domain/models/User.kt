package com.facens.acedevelop.voluntariei.domain.models

import java.util.Date

data class User(
    val id:Int,
    val name:String,
    val email:String,
    val password:String,
    val cpf:String,
    val dataNascimento:Date,
)