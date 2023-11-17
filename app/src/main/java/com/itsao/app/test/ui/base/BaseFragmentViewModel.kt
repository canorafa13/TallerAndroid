package com.itsao.app.test.ui.base

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding


abstract class BaseFragmentViewModel<T: ViewBinding, V: ViewModel>: BaseFragment<T>() {

    private lateinit var viewModel: V

    fun getViewModel(): V {
        if (!::viewModel.isInitialized){
            viewModel = inflateViewModel()
        }
        return viewModel
    }

    abstract fun inflateViewModel(): V
}