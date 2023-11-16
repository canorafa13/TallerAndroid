package com.itsao.app.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsao.app.test.databinding.FragmentConfirmationBinding
import com.itsao.app.test.ui.base.BaseFragment

class ConfirmationFragment: BaseFragment<FragmentConfirmationBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentConfirmationBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}