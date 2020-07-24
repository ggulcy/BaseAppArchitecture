package com.chanhypark.baseapparchitecture.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.app.BaseActivity
import com.chanhypark.baseapparchitecture.data.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel> {factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getUser()
        observeData()
    }


    fun observeData(){
        mainViewModel.pictureList.observe(this, Observer {
           view_pager.adapter = ImagePagerAdapter(it,mainViewModel)
        })

    }

}