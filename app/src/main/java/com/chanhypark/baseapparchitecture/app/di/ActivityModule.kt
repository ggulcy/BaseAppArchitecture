package com.chanhypark.baseapparchitecture.app.di

import com.chanhypark.baseapparchitecture.main.MainActivity
import com.chanhypark.baseapparchitecture.main.di.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule{
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    fun contributeMainActivity(): MainActivity
}