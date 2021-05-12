package com.projects.covidmvvm.data.api

import com.projects.covidmvvm.data.models.StateWiseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("data.json")
    suspend fun getStateWiseData() : StateWiseModel
}