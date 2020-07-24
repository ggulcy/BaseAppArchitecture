package com.chanhypark.baseapparchitecture.main.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.chanhypark.baseapparchitecture.R

class CustomView : LinearLayout {
    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }
    private fun init(context: Context) {
//        LayoutInflater.from(context).inflate(R.layout.item_main_tab,this,true)

    }
}