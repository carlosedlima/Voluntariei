package com.facens.acedevelop.voluntariei.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.regex.Pattern

val ViewGroup.inflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

fun ViewGroup.inflate(@LayoutRes layout: Int): View = inflater.inflate(layout, this, false)

inline fun <T> Call<T>.listen(crossinline onSuccess: (response: Response<T>) -> Unit = {}, crossinline onError: (Throwable) -> Unit = {}) {
    this.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) = onSuccess.invoke(response)
        override fun onFailure(call: Call<T>, t: Throwable) = onError.invoke(t)
    })
}

val String.isEmail: Boolean
    get() = Pattern.compile(
        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    ).matcher(this).matches()


val String.isCPF: Boolean
    get() {
        val numbers = this.numbers()
        if (numbers.length != 11 || numbers == "11111111111" || numbers == "22222222222")
            return false

        val sum = numbers.substring(0, 9).mapIndexed { index, number ->
            number.toString().toInt() * (10 - index)
        }.reduce(Int::plus)

        val sumSecond = (numbers.substring(0, 9) + numbers[9].toString()).mapIndexed { index, number ->
            number.toString().toInt() * (11 - index)
        }.reduce(Int::plus)

        val checker = (sum * 10) % 11
        val checkerSecond = (sumSecond * 10) % 11

        return (if (checker == 10) 0 else checker) == numbers[9].toString().toInt()
                && (if (checkerSecond > 9) 0 else checkerSecond) == numbers[10].toString().toInt()
    }

val String.isPassword: Boolean
    get() = this.length >= 6
val String.isName: Boolean
    get() = Pattern.compile("_?[A-zÀ-ú]*").matcher(this.replace(" ", "")).matches()

fun String.numbers(): String = this.replace(Regex("[^0-9]"), "")

fun Date.dateToString(format: String): String {

    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())

    return dateFormatter.format(this)
}