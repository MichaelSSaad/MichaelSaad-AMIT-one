
package com.example.hiltexample.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("data")
    suspend fun getData(): Response<List<DataModel>>
}
