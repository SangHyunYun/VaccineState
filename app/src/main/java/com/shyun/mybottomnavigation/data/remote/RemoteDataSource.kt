package com.shyun.mybottomnavigation.data.remote

class RemoteDataSource {
    suspend fun getData(parameters: Map<String, String>) = RetrofitService.vaccineService.getData(parameters)
}