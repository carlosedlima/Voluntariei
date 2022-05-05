package com.facens.acedevelop.voluntariei.data.datasource

import android.app.DownloadManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.OngDataSource
import com.facens.acedevelop.voluntariei.data.di.Request
import com.facens.acedevelop.voluntariei.data.di.Request.listen
import com.facens.acedevelop.voluntariei.data.interfaces.OngInterface
import com.facens.acedevelop.voluntariei.domain.models.ONG
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named
import kotlin.coroutines.suspendCoroutine

class RetrofitOngDataSource @Inject constructor(
    private val request:Retrofit
) : OngDataSource {
    override suspend fun registerOng(user: ONG): ONG {
        return suspendCoroutine {continuation ->

            request.create(OngInterface::class.java).createOng(user).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        continuation.resumeWith(Result.success(user))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }

    }

    override suspend fun getOng(id: Int): ONG {
        return suspendCoroutine {continuation ->
            request.create(OngInterface::class.java).getOng(id).listen(
                onSuccess = { response ->
                    if (response.isSuccessful){
                        val user:ONG = response.body()?.value!!
                        continuation.resumeWith(Result.success(user))
                    }
                },
                onError = {
                    continuation.resumeWith(Result.failure(it))
                }
            )
        }
    }

    override suspend fun deleteOng(id: Int): Boolean {
        TODO("Not yet implemented")
    }

}