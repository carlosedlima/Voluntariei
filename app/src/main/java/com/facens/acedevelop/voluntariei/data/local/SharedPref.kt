package com.facens.acedevelop.voluntariei.data.local

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref private constructor() {

    companion object {
        private val instance = SharedPref()
        private lateinit var sharedPreferences: SharedPreferences

        private const val NOME = "usuario_nome"
        private const val DOCUMENTO = "usuario_cpf"
        private const val MODO = "modo_usuario"
        private const val EMAIL = "email_usuario"
        private const val ID = "id_usuario"
        private const val ISONG = "ong"

        fun getInstance(context: Context): SharedPref {
            if (!Companion::sharedPreferences.isInitialized) {
                synchronized(SharedPref::class.java) {
                    if (!Companion::sharedPreferences.isInitialized) {
                        sharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
                    }
                }
            }
            return instance
        }
    }

    val nome: String?
        get() = sharedPreferences.getString(NOME, "")

    fun saveNome(nome: String) {
        sharedPreferences.edit().putString(NOME, nome).apply()
    }

    fun removeNome() {
        sharedPreferences.edit().remove(NOME).apply()
    }

    val documento: String?
        get() = sharedPreferences.getString(DOCUMENTO, "")

    fun saveDocument(documento: String) {
        sharedPreferences.edit().putString(DOCUMENTO, documento).apply()
    }

    fun removeDocument() {
        sharedPreferences.edit().remove(DOCUMENTO).apply()
    }

    val email: String?
        get() = sharedPreferences.getString(EMAIL, "")

    fun saveEmail(email: String) {
        sharedPreferences.edit().putString(EMAIL, email).apply()
    }

    fun removeEmail() {
        sharedPreferences.edit().remove(EMAIL).apply()
    }

    val userId: Long
        get() = sharedPreferences.getLong(ID, 0)

    fun saveUserId(id: Long) {
        sharedPreferences.edit().putLong(ID, id).apply()
    }

    fun removeUserId() {
        sharedPreferences.edit().remove(ID).apply()
    }

    val isFirstLogin: Boolean
        get() = sharedPreferences.getBoolean(MODO, true)

    fun saveIsFirstLogin(isFirstLogin: Boolean) {
        sharedPreferences.edit().putBoolean(MODO, isFirstLogin).apply()
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }

    val isOng: Boolean
        get() = sharedPreferences.getBoolean(ISONG, false)

    fun saveIsOng(isOng: Boolean) {
        sharedPreferences.edit().putBoolean(ISONG, isOng).apply()
    }
}