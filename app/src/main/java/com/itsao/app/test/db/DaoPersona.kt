package com.itsao.app.test.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoPersona {
    @Query("SELECT * FROM Persona")
    fun getAll(): List<Persona>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(persona: Persona): Long
}