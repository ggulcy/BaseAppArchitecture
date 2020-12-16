package com.chanhypark.baseapparchitecture.data

import android.app.AppComponentFactory
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.*
import android.util.Log
import androidx.lifecycle.*
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.chanhypark.baseapparchitecture.app.di.AppComponent
import com.chanhypark.baseapparchitecture.data.api.ApiProvider
import com.chanhypark.baseapparchitecture.data.api.GithubApi
import com.chanhypark.baseapparchitecture.data.api.ServerModule
import com.chanhypark.baseapparchitecture.data.repository.MainRepository
import dagger.Module
import dagger.android.AndroidInjection
import dagger.android.AndroidInjection.inject
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection.inject
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject


class MyService : Service(), HasAndroidInjector {

    companion object {
        const val MSG_SEND_TO_ACTIVITY = "MSG_SEND_TO_ACTIVITY"
    }

    private val mainRepository = MainRepository(
        ApiProvider.provideGithubApi()
    )

    var isLoop = MutableLiveData<Boolean>()


    var mBinder: IBinder = MyBinder()

    internal inner class MyBinder : Binder() {
        // 서비스 객체를 리턴
        val service: MyService
            get() = this@MyService
    }

    override fun onBind(intent: Intent): IBinder? {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        observe()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun observe(){

    }

     fun setLoop() {
        CoroutineScope(Dispatchers.Default).launch {
            withContext(Dispatchers.Default) {
                mainRepository.fetchData()
                var index = 0
                while (index < 100) {
                    index++
                    delay(1000L)
                    println("루프가 돌아가는중입니다 $index")
                }
            }
        }
    }

    private fun sendToMessage(s: String) {
        Intent(MSG_SEND_TO_ACTIVITY).let {
            it.putExtra("message",s)
            LocalBroadcastManager.getInstance(this).sendBroadcast(it)
        }
    }


    fun getUser() {
        CoroutineScope(Dispatchers.Default).launch {
            withContext(Dispatchers.Default) {
                val a = mainRepository.fetchData()
                a?.get(0)?.let {
                    sendToMessage(it.email)
                }
            }
        }
    }


    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }




}


