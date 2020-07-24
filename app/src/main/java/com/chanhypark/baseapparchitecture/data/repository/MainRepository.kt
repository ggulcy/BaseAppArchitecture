package com.chanhypark.baseapparchitecture.data.repository

import com.chanhypark.baseapparchitecture.data.api.GithubApi
import com.chanhypark.baseapparchitecture.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: GithubApi
) {

    suspend fun fetchData():List<User>?{
        return withContext(Dispatchers.Default) {
            api.getUser(10).await().result
        }
    }

}