package com.facens.acedevelop.voluntariei.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref private constructor() {

    companion object {
        private val sharePref = SharedPref()
        private lateinit var sharedPreferences: SharedPreferences

        private val NOME = "usuario_nome"
        private val DOCUMENTO = "usuario_cpf"
        private val MODO = "modo_usuario"
        private val EMAIL = "email_usuario"
        private val ID = "id_usuario"
        private val ISONG = "ong"


        fun getInstance(context: Context): SharedPref {
            if (!::sharedPreferences.isInitialized) {
                synchronized(SharedPref::class.java) {
                    if (!::sharedPreferences.isInitialized) {
                        sharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
                    }
                }
            }
            return sharePref
        }
    }

    val nome: String?
        get() = sharedPreferences.getString(NOME, "")

    fun saveNome(placeObjStr: String) {
        sharedPreferences.edit()
            .putString(NOME, placeObjStr)
            .apply()
    }
    fun removeNome() {
        sharedPreferences.edit().remove(NOME).apply()
    }

    val documento:String?
        get()= sharedPreferences.getString(DOCUMENTO,"")

    fun removeDoc() {
        sharedPreferences.edit().remove(DOCUMENTO).apply()
    }

    fun saveDoc(placeObjStr: String) {
        sharedPreferences.edit()
            .putString(DOCUMENTO, placeObjStr)
            .apply()
    }

    val email:String?
        get()= sharedPreferences.getString(EMAIL,"")

    fun removeEmail() {
        sharedPreferences.edit().remove(EMAIL).apply()
    }

    fun saveEmail(placeObjStr: String) {
        sharedPreferences.edit()
            .putString(EMAIL, placeObjStr)
            .apply()
    }

    val userId:Int?
        get() = sharedPreferences.getInt(ID,0)

    fun removeId(){
        sharedPreferences.edit().remove(ID).apply()
    }

    fun saveID(id:Int){
        sharedPreferences.edit()
            .putInt(ID,id)
            .apply()
    }

    val isFirstLogin:Boolean
        get()= sharedPreferences.getBoolean(MODO,true)

    fun saveIsFirstLogin(placeObjStr: Boolean) {
        sharedPreferences.edit()
            .putBoolean(MODO, placeObjStr)
            .apply()
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }

    val isOng:Boolean
        get()= sharedPreferences.getBoolean(ISONG,false)

    fun saveIsONG(placeObjStr: Boolean) {
        sharedPreferences.edit()
            .putBoolean(ISONG, placeObjStr)
            .apply()
    }

}