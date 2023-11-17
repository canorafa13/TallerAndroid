package com.itsao.app.test.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.itsao.app.test.ui.viewmodels.PersonaViewModel

abstract class BaseFragment<T: ViewBinding>: Fragment() {

    lateinit var binding: T

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): T
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateBinding(inflater, container)
        return binding.root
    }
}