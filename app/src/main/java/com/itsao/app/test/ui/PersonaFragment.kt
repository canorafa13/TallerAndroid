package com.itsao.app.test.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.itsao.app.test.R
import com.itsao.app.test.databinding.FragmentPersonaBinding
import com.itsao.app.test.db.Persona
import com.itsao.app.test.ui.base.BaseFragmentViewModel
import com.itsao.app.test.ui.viewmodels.PersonaViewModel
import com.itsao.app.test.utils.toast

class PersonaFragment: BaseFragmentViewModel<FragmentPersonaBinding, PersonaViewModel>() {

    private var persona: Persona? = null

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPersonaBinding.inflate(inflater, container, false)

    override fun inflateViewModel() = PersonaViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            persona = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getSerializable("persona", Persona::class.java)
            } else {
                arguments?.getSerializable("persona") as Persona?
            }
        }catch (e: Exception){
            e.printStackTrace()
        }


        binding.btnSave.setOnClickListener {
            try {

                var personaBD: Persona? = null

                persona?.let {
                    personaBD = persona!!

                } ?: kotlin.run { personaBD = Persona() }

                personaBD!!.apply {
                    this.name = binding.name.text.toString()
                    this.firstName = binding.firstName.text.toString()
                    this.age = binding.age.text.toString().toInt()
                }



                if (isPersonValid(personaBD!!)){
                    getViewModel().createOrUpdatePerson(personaBD!!)
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


        if (persona != null) {
            binding.name.setText(persona!!.name)
            binding.firstName.setText(persona!!.firstName)
            binding.age.setText(persona!!.age.toString())

            binding.btnDelete.visibility = View.VISIBLE
        }


        binding.btnDelete.setOnClickListener {
            getViewModel().deletePerson(persona!!.id)
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