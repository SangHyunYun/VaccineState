package com.shyun.mybottomnavigation.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shyun.mybottomnavigation.R
import com.shyun.mybottomnavigation.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var mBinding: FragmentNotificationsBinding
    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNotificationsBinding.inflate(inflater)
        notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        mBinding.viewModel = notificationsViewModel
        return mBinding.root
    }
}