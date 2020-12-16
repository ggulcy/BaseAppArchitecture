package com.chanhypark.baseapparchitecture.data

import android.app.*
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.*
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat.from
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.chanhypark.baseapparchitecture.main.ui.MainActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.main.ui.view_model.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MyLifeCycleService : LifecycleService(), HasAndroidInjector {

    var mBinder: IBinder = MyBinder()

    private lateinit var mViewModel: MainViewModel

    internal inner class MyBinder : Binder() {
        // 서비스 객체를 리턴
        val service: MyLifeCycleService
            get() = this@MyLifeCycleService
    }


    override fun onBind(intent: Intent): IBinder? {
        super.onBind(intent)
        return mBinder
    }


    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    companion object {
        const val CHANNEL_ID = "ForegroundServiceChannel"
    }

    val data = MutableLiveData<Boolean>(false)

    lateinit var mainViewModel: MainViewModel

    lateinit var notificationManager:NotificationManager
    override fun onCreate() {


        createNotificationChannel()
        startForegroundService()

        super.onCreate()
    }





    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("chanhypark ")
        data.observe(this, Observer {
            println("data : $it")
        })


        return super.onStartCommand(intent, flags, startId)
    }

    override fun startForegroundService(service: Intent?): ComponentName? {
        println("on start")
        return super.startForegroundService(service)
    }


    fun sendMessage(){
        println("chanhypark ${mainViewModel.isService}")
        mainViewModel.isService.value = true
        CoroutineScope(Dispatchers.Default).launch {
            delay(5000L)
            notificationManager.apply {
                notify(1, makeNotification("하잉"))
            }
        }

    }

    fun setViewModel(viewModel: MainViewModel){
        mainViewModel = viewModel
    }
    private fun makeNotification(message:String):Notification{
        val notificationIntent = Intent(this,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0)
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()
    }
    private fun startForegroundService(){
        startForeground(1,makeNotification("START"))
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }

    }

}
