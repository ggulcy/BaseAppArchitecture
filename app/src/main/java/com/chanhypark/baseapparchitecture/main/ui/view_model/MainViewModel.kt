package com.chanhypark.baseapparchitecture.main.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chanhypark.baseapparchitecture.data.model.User
import com.chanhypark.baseapparchitecture.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    var userList = MutableLiveData<List<User>>()
    var pictureList = MutableLiveData<List<User.Picture>>()
    val isService = MutableLiveData<Boolean>(false)
    fun getUser() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Main){
                try {
                    mainRepository.fetchData()?.let {
                        userList.value = it

                        var pList = ArrayList<User.Picture>()
                        it.forEach {user->
                            pList.add(user.picture)
                        }
                        pictureList.value = pList

                    }
                }catch (e:Exception){
                    println(e.message)
                }
            }
        }

    }





}




