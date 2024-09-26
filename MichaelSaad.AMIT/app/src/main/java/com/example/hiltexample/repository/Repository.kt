
package com.example.hiltexample.repository

import com.example.hiltexample.network.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    suspend fun fetchData(): List<DataModel> {
        val response = apiService.getData()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw Exception("Failed to load data")
        }
    }
}
