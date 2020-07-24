package com.chanhypark.baseapparchitecture.data.api

import com.chanhypark.baseapparchitecture.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface GithubApi{

    @GET("/")
    fun getUser(
        @Query("results") result:Int
    ): Call<UserResponse>



}
