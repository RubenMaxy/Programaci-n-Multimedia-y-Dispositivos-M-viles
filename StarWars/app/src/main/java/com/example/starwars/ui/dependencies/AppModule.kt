package com.example.starwars.ui.dependencies

import android.content.Context
import androidx.room.Room
import com.example.starwars.ui.room.baseDatos.FavoritosDB

object AppModule {
    fun provideDatabase(context: Context): FavoritosDB {
        return Room.databaseBuilder(
            context.applicationContext,
            FavoritosDB::class.java,
            "favoritos_db"
        ).build()
    }

}
