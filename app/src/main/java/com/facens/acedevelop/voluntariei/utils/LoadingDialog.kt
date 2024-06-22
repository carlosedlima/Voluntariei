package com.facens.acedevelop.voluntariei.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.facens.acedevelop.voluntariei.R

object LoadingDialog {
    lateinit var builder:Dialog
    fun startLoadingDialog(context: Context) {
        builder = Dialog(context)
        builder.setContentView(R.layout.loading_dialog)
        builder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder.setCancelable(true)
        builder.create()
        builder.show()
    }

    fun dismissDialog() {
        builder.dismiss()
    }
}