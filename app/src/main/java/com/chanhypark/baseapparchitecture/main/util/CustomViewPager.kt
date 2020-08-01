package com.chanhypark.baseapparchitecture.main.util

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager.widget.ViewPager


class CustomViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ViewPager(context, attrs) {


    private var enabled: Boolean? = null
    init {
        enabled = false
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        try {
            enabled?.let {
                if(it) return super.onTouchEvent(ev);
            }
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace();
        }
        return false;
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        try {
            enabled?.let {
                if(it) return super.onInterceptTouchEvent(ev);
            }
        } catch (ex:IllegalArgumentException) {
            ex.printStackTrace();
        }
        return false;
    }

    fun setPagingEnabled(enabled : Boolean){
        this.enabled = enabled
    }
}