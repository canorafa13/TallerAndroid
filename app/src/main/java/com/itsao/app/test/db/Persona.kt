package com.itsao.app.test.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Persona")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "firstName")
    var firstName: String = "",

    @ColumnInfo(name = "age")
    var age: Int = 0
)