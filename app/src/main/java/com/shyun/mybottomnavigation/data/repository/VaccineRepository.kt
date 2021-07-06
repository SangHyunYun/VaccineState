package com.shyun.mybottomnavigation.data.repository

import com.shyun.mybottomnavigation.data.remote.RemoteDataSource

class VaccineRepository(private val remote: RemoteDataSource) : Repository {
    override suspend fun getData(parameters: Map<String, String>) =
        remote.getData(parameters)
}