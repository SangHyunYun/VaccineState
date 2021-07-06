package com.shyun.mybottomnavigation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shyun.mybottomnavigation.R
import com.shyun.mybottomnavigation.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var mBinding: FragmentDashboardBinding
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDashboardBinding.inflate(inflater)
        dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        mBinding.viewModel = dashboardViewModel

        return mBinding.root
    }
}