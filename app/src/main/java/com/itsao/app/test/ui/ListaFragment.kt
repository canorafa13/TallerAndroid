package com.itsao.app.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.itsao.app.test.databinding.FragmentListaBinding
import com.itsao.app.test.ui.base.BaseFragment

class ListaFragment: BaseFragment<FragmentListaBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentListaBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "Aqui va una lista", Toast.LENGTH_SHORT).show()
    }
}