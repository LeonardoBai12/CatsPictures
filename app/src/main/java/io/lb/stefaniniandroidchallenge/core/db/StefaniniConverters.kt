package io.lb.stefaniniandroidchallenge.core.db

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import io.lb.stefaniniandroidchallenge.model.picture.Picture


class StefaniniConverters {
    private val gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): ArrayList<Picture?>? {
        if (data.isNullOrEmpty()) {
            return null
        }
        val listType = object : TypeToken<ArrayList<Picture?>?>() {}.type
        return gson.fromJson<ArrayList<Picture?>?>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObject: ArrayList<Picture?>?): String {
        return gson.toJson(someObject)
    }
}