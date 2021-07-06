package com.shyun.mybottomnavigation.data.remote

import com.shyun.mybottomnavigation.model.VaccineResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface VaccineService {

    @GET("api/15077756/v1/vaccine-stat")
    suspend fun getData(@QueryMap parameters: Map<String, String>): VaccineResponse

}