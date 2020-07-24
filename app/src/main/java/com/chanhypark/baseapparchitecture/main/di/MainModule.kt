package com.chanhypark.baseapparchitecture.main.di

import androidx.lifecycle.ViewModel
import com.chanhypark.baseapparchitecture.app.di.ViewModelKey
import com.chanhypark.baseapparchitecture.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

}