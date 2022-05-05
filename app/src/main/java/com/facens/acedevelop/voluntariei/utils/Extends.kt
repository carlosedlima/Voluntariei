package com.facens.acedevelop.voluntariei.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import java.util.regex.Pattern

val ViewGroup.inflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

fun ViewGroup.inflate(@LayoutRes layout: Int): View = inflater.inflate(layout, this, false)

//fun ResponseBody.error(): RequestError? = try {
//    Gson().fromJson(string(), RequestError::class.java)
//} catch (error: Throwable) {
//    null
//}


/**
 * Verify if [String] is a validation email
 */
val String.isEmail: Boolean
    get() = Pattern.compile(
        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    ).matcher(this).matches()


/**
 * Verify if [String] is a CPF
 */
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

/**
 * Verify if [String] is equal to or greater than six
 */
val String.isPassword: Boolean
    get() = this.length >= 6
val String.isName: Boolean
    get() = Pattern.compile("_?[A-zÀ-ú]*").matcher(this.replace(" ", "")).matches()
/**
 * Return string with only numbers
 */
fun String.numbers(): String = this.replace(Regex("[^0-9]"), "")