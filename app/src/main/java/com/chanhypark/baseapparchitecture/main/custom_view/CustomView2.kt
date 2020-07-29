package com.chanhypark.baseapparchitecture.main.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.chanhypark.baseapparchitecture.R

class CustomView2 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        initView()
    }

    private fun initView(){
        val view = LayoutInflater.from(context).inflate(R.layout.item_custom,this,false)
       addView(view)
    }

}