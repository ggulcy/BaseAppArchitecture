package com.chanhypark.baseapparchitecture.main

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.activity.viewModels
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.app.BaseActivity
import com.chanhypark.baseapparchitecture.main.custom_view.CustomView
import com.chanhypark.baseapparchitecture.main.custom_view.CustomView2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel> {factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getUser()
        observeData()

        container.addView(CustomView2(this))
//        LinearLayout mEmailLinear = (LinearLayout)getView().findViewById(R.id. 추가할 위치의 LinearLayout id );
//        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View emailNewField = inflater.inflate(R.layout. 추가할 뷰의 layout xml 파일명 , null);
//        mEmailLinear.addView(emailNewField);


//        val view = LayoutInflater.from(this).inflate(R.layout.item_custom,null)

//        container.addView(view)

    }


    fun observeData(){
//        mainViewModel.pictureList.observe(this, Observer {
//           view_pager.adapter = ImagePagerAdapter(it,mainViewModel)
//        })

    }

}