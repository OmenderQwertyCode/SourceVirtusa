package com.example.task.remote


import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getApiData(id:String) =
        apiService.getApiData(id)

 }