package com.itsao.app.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.itsao.app.test.databinding.FragmentHomeBinding
import com.itsao.app.test.ui.base.BaseFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnLista.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.homeFragmentToListaFragment())
        }

        binding.btnPersona.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.homeFragmentToPersonaFragment())
        }

    }
}