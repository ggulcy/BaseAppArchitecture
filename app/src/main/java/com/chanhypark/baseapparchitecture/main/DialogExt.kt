package com.chanhypark.baseapparchitecture.main

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import androidx.fragment.app.DialogFragment


fun DialogFragment.getDeviceSize(context: Context?):Pair<Int,Int>{
    val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return Pair(size.x,size.y)
}

