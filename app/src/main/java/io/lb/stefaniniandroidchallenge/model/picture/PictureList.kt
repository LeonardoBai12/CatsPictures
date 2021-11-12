package io.lb.stefaniniandroidchallenge.model.picture

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class PictureList(
    val images: List<Picture>
)

class TypeConverterPictureList {
    private val gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): PictureList? {
        if (data.isNullOrEmpty()) {
            return null
        }
        val listType = object : TypeToken<PictureList?>() {}.type
        return gson.fromJson<PictureList?>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObject: PictureList?): String {
        return gson.toJson(someObject)
    }
}