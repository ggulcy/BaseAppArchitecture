package com.chanhypark.baseapparchitecture.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.app.BaseActivity
import com.chanhypark.baseapparchitecture.main.custom_view.CustomBottomSheet
import com.chanhypark.baseapparchitecture.main.custom_view.SuperBottomSheet
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_fragment.*

class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel> {factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getUser()
        observeData()

        bottom_btn.setOnClickListener {
//        CustomBottomSheet.newInstance().show(supportFragmentManager,CustomBottomSheet.TAG_DIALOG)
            val customBottomSheet = SuperBottomSheet()
            customBottomSheet.show(supportFragmentManager,SuperBottomSheet.TAG_DIALOG)

        }


    }






    fun observeData(){
        mainViewModel.pictureList.observe(this, Observer {
           view_pager.adapter = ImagePagerAdapter(it,mainViewModel,onImageClick)
        })
    }

    private var onImageClick: ((position:Int) -> Unit)? = {


//       ImageDialogFragment.newInstance().show(
//            supportFragmentManager,ImageDialogFragment.TAG_DIALOG
//        )


//        CustomBottomSheet.newInstance().show(supportFragmentManager,CustomBottomSheet.TAG_DIALOG)
//        val customBottomSheet = CustomBottomSheet()
//        customBottomSheet.show(supportFragmentManager,CustomBottomSheet.TAG_DIALOG)

    }



}