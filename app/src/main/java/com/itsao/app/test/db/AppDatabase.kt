package com.itsao.app.test.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.itsao.app.test.AppITSAO

@Database(entities = [Persona::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    AppITSAO.instance!!,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).build()
            }
            return INSTANCE!!
        }
    }




    abstract fun userDao(): DaoPersona
}