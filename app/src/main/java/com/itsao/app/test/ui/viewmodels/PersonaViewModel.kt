package com.itsao.app.test.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itsao.app.test.db.AppDatabase
import com.itsao.app.test.db.Persona
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonaViewModel: ViewModel() {
    private val db = AppDatabase.getInstance()

    val personaObserver = MutableLiveData<Boolean>()

    val listPersonasObserver = MutableLiveData<List<Persona>>()

    fun createPerson(persona: Persona){
        CoroutineScope(Dispatchers.IO).launch {
            val value = db.userDao().insert(persona)
            if (value > 0){
                personaObserver.postValue(true)
            } else {
                personaObserver.postValue(false)
            }
        }
    }

    fun getAllPersons() {
        CoroutineScope(Dispatchers.IO).launch {
            val value = db.userDao().getAll()
            listPersonasObserver.postValue(value)
        }
    }

}