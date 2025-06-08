package com.example.starwars.ui.room.baseDatos
import android.content.Context
import androidx.room.*
import com.example.starwars.ui.room.Converters.Converters
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.room.entidades.Favorito

@Database(entities = [Favorito::class], version = 2) // Asegúrate de aumentar la versión al cambiar la estructura
@TypeConverters(Converters::class) // Agregamos los convertidores para listas
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoritosDao(): FavoritosDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                                context.applicationContext,
                                AppDatabase::class.java,
                                "favoritos_db"
                            ).fallbackToDestructiveMigration(true) // Permite eliminar la base de datos si el esquema cambia
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}


