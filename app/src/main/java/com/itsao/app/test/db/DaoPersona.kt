package com.itsao.app.test.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


/**
 * CRUD
 * C -> Crear
 * R -> Read
 * U -> Update
 * D -> Delete
 * */
@Dao
interface DaoPersona {
    @Query("SELECT * FROM Persona")
    fun getAll(): List<Persona>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(persona: Persona): Long

    @Update
    fun update(vararg persona: Persona): Int

    @Query("DELETE FROM Persona WHERE id = :id")
    fun deletePerson(id: Int): Int
}