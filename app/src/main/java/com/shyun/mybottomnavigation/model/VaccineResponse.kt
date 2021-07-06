package com.shyun.mybottomnavigation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VaccineResponse(
    val currentCount: Int,
    val data: List<Data>,
    val matchCount: Int,
    val page: Int,
    val perPage: Int,
    val totalCount: Int
) : Parcelable {
    @Parcelize
    data class Data(
        val accumulatedFirstCnt: Int,
        val accumulatedSecondCnt: Int,
        val baseDate: String,
        val firstCnt: Int,
        val secondCnt: Int,
        val sido: String,
        val totalFirstCnt: Int,
        val totalSecondCnt: Int
    ) : Parcelable
}
