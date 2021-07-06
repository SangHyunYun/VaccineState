package com.shyun.mybottomnavigation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shyun.mybottomnavigation.data.remote.RemoteDataSource
import com.shyun.mybottomnavigation.data.repository.VaccineRepository
import com.shyun.mybottomnavigation.model.VaccineResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val TAG = "HomeViewModel"

    private val _dataList = MutableLiveData<List<VaccineResponse.Data>>()
    val dataList: LiveData<List<VaccineResponse.Data>>
        get() = _dataList

    fun requestVaccine(sido: String?, date: String?)  {
        viewModelScope.launch(Dispatchers.IO) {
            VaccineRepository(RemoteDataSource()).run {
                getData(getDefaultParameters().apply {
                    sido?.let {
                        this["cond[sido::EQ]"] = it
                    }
                    date?.let {
                        this["cond[baseDate::EQ]"] = "$it"
//                    this["cond[baseDate::EQ]"] = "2021-07-02 00:00:00"
                    }

                }).let {
                    Log.d(TAG, "requestVaccine: ${it.data}")
                    _dataList.postValue(it.data)
                }
            }
        }
    }

    private fun getDefaultParameters(): MutableMap<String, String> {
        val map = HashMap<String, String>()
        map["page"] = "1"
        map["perPage"] = "100"
        map["serviceKey"] = "oy5kULPNlDRzBlsAJzwDl7OTEXCIQHSKmNDW7/fHZc03hBIUwoEZemcvPspyWqmwzMm7oE5DlrCNXbIIPAlvfA=="
        return map
    }
}