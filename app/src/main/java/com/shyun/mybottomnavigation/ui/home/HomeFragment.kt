package com.shyun.mybottomnavigation.ui.home

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shyun.mybottomnavigation.BuildConfig
import com.shyun.mybottomnavigation.R
import com.shyun.mybottomnavigation.databinding.FragmentHomeBinding
import com.shyun.mycorona.util.DateUtil

class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"
    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        mBinding.lifecycleOwner = this
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        mBinding.viewModel = homeViewModel

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            requestVaccine()
        }
//        initObserver()
        return mBinding.root
    }

    private fun initObserver() {
        homeViewModel.dataList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "initObserver: $it")
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun requestVaccine() {
        homeViewModel.requestVaccine(null, DateUtil.getCurrentTime())
    }
}