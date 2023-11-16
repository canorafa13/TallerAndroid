package com.itsao.app.test.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T: ViewBinding>: Fragment() {

    lateinit var binding: T

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): T
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateBinding(inflater, container)
        //binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}