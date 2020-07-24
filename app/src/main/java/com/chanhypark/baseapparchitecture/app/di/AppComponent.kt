package com.chanhypark.baseapparchitecture.app.di

import com.chanhypark.baseapparchitecture.app.BaseApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class
    ]
)

interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Factory
    abstract class Factory:AndroidInjector.Factory<BaseApplication>
}