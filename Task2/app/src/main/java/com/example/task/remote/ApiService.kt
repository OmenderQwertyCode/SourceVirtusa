package com.example.task.remote


import com.example.task.Response.ApiData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{id}")
    suspend fun getApiData(
       @Path("id") id:String
    ): Response<ApiData>


}

