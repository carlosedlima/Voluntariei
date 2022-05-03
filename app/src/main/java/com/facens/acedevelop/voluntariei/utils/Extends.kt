package com.facens.acedevelop.voluntariei.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val ViewGroup.inflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

fun ViewGroup.inflate(@LayoutRes layout: Int): View = inflater.inflate(layout, this, false)

//fun ResponseBody.error(): RequestError? = try {
//    Gson().fromJson(string(), RequestError::class.java)
//} catch (error: Throwable) {
//    null
//}

