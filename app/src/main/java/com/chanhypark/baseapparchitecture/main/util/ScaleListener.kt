package com.chanhypark.baseapparchitecture.main.util

import android.view.ScaleGestureDetector
import android.widget.ImageView
import kotlin.math.max
import kotlin.math.min


class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
    private val mScaleGestureDetector: ScaleGestureDetector? = null
    private var mScaleFactor = 1.0f
    private val mImageView: ImageView? = null

    override fun onScale(detector: ScaleGestureDetector?): Boolean {
        // ScaleGestureDetector에서 factor를 받아 변수로 선언한 factor에 넣고
        detector?.let {
            mScaleFactor *= it.scaleFactor
        }

        // 최대 10배, 최소 10배 줌 한계 설정
        mScaleFactor = max(0.1f, min(mScaleFactor, 10.0f));

        // 이미지뷰 스케일에 적용
        mImageView?.apply {
            scaleX = mScaleFactor
            scaleY = mScaleFactor
        }
        return true
    }





}