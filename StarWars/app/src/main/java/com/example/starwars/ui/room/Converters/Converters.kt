package com.example.starwars.ui.room.Converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromListString(value: List<String>): String {
        return Gson().toJson(value) // Convertimos `List<String>` a `String`
    }

    @TypeConverter
    fun toListString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType) // Convertimos `String` de vuelta a `List<String>`
    }
}
