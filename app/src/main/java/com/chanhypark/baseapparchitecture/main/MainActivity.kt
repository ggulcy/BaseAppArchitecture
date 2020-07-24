package com.chanhypark.baseapparchitecture.main

import android.os.Bundle
import androidx.activity.viewModels
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.app.BaseActivity

class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel> {factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getUser()
    }


}