package com.chanhypark.baseapparchitecture.main

import androidx.lifecycle.ViewModel
import com.chanhypark.baseapparchitecture.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {


    fun getUser() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Main){
                try {
                    mainRepository.fetchData()?.let {
                        println("${it[0].email} <----")
                    }
                }catch (e:Exception){
                    println(e.message)
                }
            }
        }

    }





}




