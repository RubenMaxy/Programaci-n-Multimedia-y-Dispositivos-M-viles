package com.example.starwars.ui.dependencies

import android.content.Context
import androidx.room.Room
import com.example.starwars.ui.room.baseDatos.AppDatabase

object AppModule {
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "favoritos_db"
        ).build()
    }

}
