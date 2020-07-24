package com.chanhypark.baseapparchitecture.app.di

import android.content.Context
import com.chanhypark.baseapparchitecture.app.BaseApplication
import com.chanhypark.baseapparchitecture.data.api.ServerModule
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module(includes = [ViewModelFactoryModule::class, ServerModule::class])
abstract class AppModule{
    @Binds
    @Singleton
    abstract fun provideApplicationContext(application: BaseApplication): Context

}