package com.chanhypark.baseapparchitecture.main

import android.content.Context
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.chanhypark.baseapparchitecture.R

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}


fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        add(frameId, fragment)
    }
}


fun AppCompatActivity.addFragmentWithStack(fragment: Fragment, frameId: Int, name: String? = null) {
    supportFragmentManager.transact {
        add(frameId, fragment)
        addToBackStack(name)
    }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}


fun Window.setStatusBarColorCustom(colorId: Int, isLightStatusBar: Boolean) {
    if (Build.VERSION.SDK_INT >= 23) {
        this.apply {
            statusBarColor = ContextCompat.getColor(context, colorId)
            if (isLightStatusBar) decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    } else {
//        this.apply {
//            statusBarColor = ContextCompat.getColor(context, colorId)
//            if (isLightStatusBar) {
//                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            }
//        }
    }
}