package com.chanhypark.baseapparchitecture.main.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.*
import android.os.*
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.app.BaseActivity
import com.chanhypark.baseapparchitecture.data.MyLifeCycleService
import com.chanhypark.baseapparchitecture.data.MyService
import com.chanhypark.baseapparchitecture.main.ui.view_model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mainViewModel by viewModels<MainViewModel> {factory}

    lateinit var ms:MyLifeCycleService
    lateinit var mServiceMessenger:Messenger


    private val conn = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val mb = service as MyLifeCycleService.MyBinder
            ms = mb.service
            ms.setViewModel(mainViewModel)
            mainViewModel.isService.value = true

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mainViewModel.isService.value = false
        }

    }

    private val mMessageReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
               val a = intent?.getStringExtra("message")
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent= Intent(this, MyLifeCycleService::class.java)
        bindService(intent, conn, Context.BIND_AUTO_CREATE)
        observeData()

        btn_service.setOnClickListener {
            ms.sendMessage()
        }
//
//        btn_service.setOnClickListener {
//            mainViewModel.isService.value = mainViewModel.isService.value?.not()
//        }

//        val intent = Intent(this,MyLifeCycleService::class.java)
//        startForegroundService(intent)


    }






    override fun onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver( mMessageReceiver, IntentFilter(MyService.MSG_SEND_TO_ACTIVITY))
        super.onResume()

    }

    private fun observeData(){
        with(mainViewModel){
            isService.observe(this@MainActivity, Observer {
                println("isService $it")
//                if(it) ms.setLoop()
//                else ms.setLoop()
            })
        }
    }




}