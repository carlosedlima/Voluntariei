package com.facens.acedevelop.voluntariei.data.datasource

import com.facens.acedevelop.voluntariei.data.di.Request
import com.facens.acedevelop.voluntariei.data.datasource.interfaces.HelpDataSource
import com.facens.acedevelop.voluntariei.data.di.Request.listen
import com.facens.acedevelop.voluntariei.data.interfaces.HelpInterface
import com.facens.acedevelop.voluntariei.domain.models.Help
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RetrofitHelpDataSource @Inject constructor(
    val request: Request
) : HelpDataSource {

     override suspend fun getHelps(): List<Help> {

        return suspendCoroutine { continuation ->
            request.create(HelpInterface::class.java).getHelps().listen(
               onSuccess = { response ->
                    if (response.isSuccessful){
                        val helps = mutableListOf<Help>()
                        response.body()?.forEach { help ->
                            helps.add(help)
                        }

                        continuation.resumeWith(Result.success(helps))
                    }
               },
               onError = {
                   continuation.resumeWith(Result.failure(it))
               }
           )
        }

    }

}