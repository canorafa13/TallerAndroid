package com.itsao.app.test.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.itsao.app.test.db.AppDatabase
import com.itsao.app.test.db.Persona
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonaViewModel: ViewModel() {
    private val db = AppDatabase.getInstance()
    fun createPerson(persona: Persona){
        CoroutineScope(Dispatchers.IO).launch {
            db.userDao().insert(persona)
        }
    }

}