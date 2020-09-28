package com.chanhypark.baseapparchitecture.main.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.app.BaseActivity
import com.chanhypark.baseapparchitecture.main.replaceFragmentInActivity
import com.chanhypark.baseapparchitecture.main.ui.view_model.MainViewModel

class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel> {factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getUser()

        replaceFragmentInActivity(MainFragment.newInstance(),R.id.layout_fr)
//        observeData()
    }




}