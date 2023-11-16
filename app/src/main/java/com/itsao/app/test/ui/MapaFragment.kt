package com.itsao.app.test.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.itsao.app.test.databinding.FragmentMapaBinding
import com.itsao.app.test.ui.base.BaseFragment

class MapaFragment: BaseFragment<FragmentMapaBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMapaBinding.inflate(inflater, container, false)

}