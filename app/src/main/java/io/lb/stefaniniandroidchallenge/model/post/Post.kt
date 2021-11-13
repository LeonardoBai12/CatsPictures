package io.lb.stefaniniandroidchallenge.model.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.lb.stefaniniandroidchallenge.core.GeneralConstants
import io.lb.stefaniniandroidchallenge.model.picture.Picture

@Entity(tableName = GeneralConstants.POSTS)
data class Post(
    @PrimaryKey
    @ColumnInfo(name = PostConstants.ID)
    val id: String,
    @ColumnInfo(name = PostConstants.TITLE)
    val title: String?,
    @ColumnInfo(name = PostConstants.VIEWS)
    val views: Int?,
    @ColumnInfo(name = PostConstants.DESCRIPTION)
    val description: String?,
    @ColumnInfo(name = PostConstants.PICTURES)
    @field:SerializedName(PostConstants.PICTURES)
    val pictures: ArrayList<Picture?>?
)