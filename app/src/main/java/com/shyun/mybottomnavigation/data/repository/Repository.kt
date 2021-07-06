package com.shyun.mybottomnavigation.data.repository

import com.shyun.mybottomnavigation.model.VaccineResponse

interface Repository {
    suspend fun getData(parameters: Map<String, String>): VaccineResponse
}