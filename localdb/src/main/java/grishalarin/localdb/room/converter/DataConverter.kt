package grishalarin.localdb.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import grishalarin.localdb.room.entity.CurrencyEntity
import java.io.Serializable
import java.lang.reflect.Type


/**
 * @author Sostavkin Grisha
 */
class DataConverter : Serializable {
    @TypeConverter // note this annotation
    fun fromList(strings: List<CurrencyEntity>?): String? {
        if (strings == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<CurrencyEntity>?>() {}.type
        return gson.toJson(strings, type)
    }

    @TypeConverter // note this annotation
    fun toList(strings: String?): List<CurrencyEntity>? {
        if (strings == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<CurrencyEntity>?>() {}.type
        return gson.fromJson(strings, type)
    }
}