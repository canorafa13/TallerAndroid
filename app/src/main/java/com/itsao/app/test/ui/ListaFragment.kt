package com.itsao.app.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itsao.app.test.databinding.FragmentListaBinding
import com.itsao.app.test.ui.adapters.PersonasAdapter
import com.itsao.app.test.ui.base.BaseFragment
import com.itsao.app.test.ui.base.BaseFragmentViewModel
import com.itsao.app.test.ui.viewmodels.PersonaViewModel

class ListaFragment: BaseFragmentViewModel<FragmentListaBinding, PersonaViewModel>() {



    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentListaBinding.inflate(inflater, container, false)

    override fun inflateViewModel() = PersonaViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewModel().listPersonasObserver.observe(viewLifecycleOwner){ list ->
            binding.lista.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = PersonasAdapter(list) { persona ->
                    findNavController().navigate(ListaFragmentDirections.listaFragmentToPersonaFragment(persona))
                }
            }
        }


        getViewModel().getAllPersons()
    }
}