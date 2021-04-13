package com.chanhypark.baseapparchitecture.main.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.app.BaseActivity
import com.chanhypark.baseapparchitecture.main.replaceFragmentInActivity
import com.chanhypark.baseapparchitecture.main.setStatusBarColorCustom
import com.chanhypark.baseapparchitecture.main.ui.view_model.MainViewModel

class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel> {factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getUser()



        this.window.setStatusBarColorCustom(R.color.colorRed,false)

//
//        if(Build.VERSION.SDK_INT >= 23){
//            window.apply {
////                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//                statusBarColor = ContextCompat.getColor(context,R.color.colorYellow)
//                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//            }
//        }else{
//            window.apply {
//                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//                statusBarColor = ContextCompat.getColor(context,R.color.colorYellow)
//            }
//        }




        replaceFragmentInActivity(MainFragment.newInstance(),R.id.layout_fr)
//        observeData()
    }




}