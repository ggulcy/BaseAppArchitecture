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
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        val str = a.getString(R.styleable.CustomView_customtype)
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        val str = a.getString(R.styleable.CustomView_customtype)
        println("chantest :$str")
        init(context)


    }
    private fun init(context: Context) {
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.item_custom, this, true)




    }
}