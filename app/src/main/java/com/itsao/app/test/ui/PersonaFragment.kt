package com.itsao.app.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.itsao.app.test.R
import com.itsao.app.test.databinding.FragmentPersonaBinding
import com.itsao.app.test.db.Persona
import com.itsao.app.test.ui.base.BaseFragment
import com.itsao.app.test.ui.base.BaseFragmentViewModel
import com.itsao.app.test.ui.viewmodels.PersonaViewModel
import com.itsao.app.test.utils.toast

class PersonaFragment: BaseFragmentViewModel<FragmentPersonaBinding, PersonaViewModel>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPersonaBinding.inflate(inflater, container, false)

    override fun inflateViewModel() = PersonaViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSave.setOnClickListener {
            try {
                val persona = Persona().apply {
                    this.name = binding.name.text.toString()
                    this.firstName = binding.firstName.text.toString()
                    this.age = binding.age.text.toString().toInt()
                }

                if (isPersonValid(persona)){
                    getViewModel().createPerson(persona)
                } else {
                    toast(R.string.message_error_form)
                }
            } catch (e: Exception){
                e.printStackTrace()
                toast(R.string.message_error_form)
            }
        }





        getViewModel().personaObserver.observe(viewLifecycleOwner){ result ->
            if (result) {
                //TODO OK
                findNavController().navigate(PersonaFragmentDirections.personaFragmentToConfirmationFragment())
            } else {
                // TODO FAILED
                toast(R.string.message_error_bd_persona)
            }
        }

    }

    private fun isPersonValid(persona: Persona): Boolean{
        if (persona.name.isEmpty()){
            return false
        }

        if (persona.firstName.isEmpty()){
            return false
        }

        return true
    }

}