package com.facens.acedevelop.voluntariei.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Request {


    private val request: Retrofit.Builder= Retrofit.Builder()

    @Provides
    @Singleton
    fun providesRetrofit():Retrofit{
        return request
            .baseUrl("http://localhost:8090")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().run {
                callTimeout(10L, TimeUnit.SECONDS)
                connectTimeout(10L, TimeUnit.SECONDS)
                readTimeout(10L, TimeUnit.SECONDS)
                writeTimeout(10L, TimeUnit.SECONDS)
                build()
            })
            .build()
    }


    inline fun <T> Call<T>.listen(crossinline onSuccess: (response: Response<T>) -> Unit = {}, crossinline onError: (Throwable) -> Unit = {}) {
        this.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) = onSuccess.invoke(response)
            override fun onFailure(call: Call<T>, t: Throwable) = onError.invoke(t)
        })
    }


//    private class InterceptorRequest : Interceptor {
//        override fun intercept(chain: Interceptor.Chain): Response {
//            return chain.proceed(chain.request().newBuilder().run {
//                if (chain.request().header("content-type") == null)
//                    addHeader("content-type", "application/json")
//
//                if (chain.request().header("accept") == null)
//                    addHeader("accept", "application/json")
//
//                addHeader("app-version", "Ab${BuildConfig.VERSION_CODE}v${BuildConfig.VERSION_NAME}")
//                build()
//            })
//        }
//    }
//
//    private class AuthenticateInterceptor : Authenticator {
//        override fun authenticate(route: Route?, response: Response): Request? {
//            val token = synchronized(this) { Shared.instance.token }
//            val responseRefresh = create(AuthInterface::class.java).refreshToken(RefreshToken(token?.refreshToken ?: "")).execute()
//            if (responseRefresh.isSuccessful) {
//                val newToken = responseRefresh.body()
//                synchronized(this) {
//                    Shared.instance.token = newToken
//                }
//                return response.request.newBuilder()
//                    .header("Authorization", newToken?.bearerToken ?: "")
//                    .build()
//            }
//            return null
//        }
//    }

//    private class ExcludeJson : ExclusionStrategy {
//        override fun shouldSkipClass(clazz: Class<*>?): Boolean = false
//
//        override fun shouldSkipField(f: FieldAttributes?): Boolean {
//            return f?.getAnnotation(Exclude::class.java) != null
//        }
//    }

}