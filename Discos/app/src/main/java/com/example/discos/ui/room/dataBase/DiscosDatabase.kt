package com.example.discos.ui.room.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.discos.ui.data.Discos
import com.example.discos.ui.room.dao.DiscosDao

@Database(entities = [Discos::class], version = 1)
abstract class DiscosDatabase : RoomDatabase() {
    abstract fun discoDao(): DiscosDao

    companion object {
        @Volatile
        private var INSTANCE: DiscosDatabase? = null

        fun getDatabase(context: Context): DiscosDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DiscosDatabase::class.java,
                    "disco_database"
                ).fallbackToDestructiveMigration(true) // Maneja cambios en el esquema
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
