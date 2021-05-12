package com.projects.covidmvvm.data.repos

import com.projects.covidmvvm.data.api.Client

object Covid19Repository {
    suspend fun getStateWiseData() = Client.api.getStateWiseData()
}