package io.lb.stefaniniandroidchallenge.model.picture

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class Picture(
    @field:SerializedName(PictureConstants.URL)
    val url: String?,
    @ColumnInfo(name = PictureConstants.TITLE)
    val title: String?,
    @ColumnInfo(name = PictureConstants.VIEWS)
    val views: Int?,
    @ColumnInfo(name = PictureConstants.DESCRIPTION)
    val description: String?,
)