package grishalarin.localdb.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import grishalarin.localdb.room.entity.ValuteEntity
import java.io.Serializable
import java.lang.reflect.Type

/**
 * @author Sostavkin Grisha
 */
class ValuteConverter : Serializable {
    @TypeConverter // note this annotation
    fun fromValute(valute: ValuteEntity?): String? {
        if (valute == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<ValuteEntity?>() {}.type
        return gson.toJson(valute, type)
    }

    @TypeConverter // note this annotation
    fun toValute(strings: String?): ValuteEntity? {
        if (strings == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<ValuteEntity?>() {}.type
        return gson.fromJson(strings, type)
    }
}