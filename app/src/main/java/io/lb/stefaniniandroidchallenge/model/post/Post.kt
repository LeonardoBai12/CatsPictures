package io.lb.stefaniniandroidchallenge.model.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.lb.stefaniniandroidchallenge.core.GeneralConstants
import io.lb.stefaniniandroidchallenge.model.picture.Picture
import io.lb.stefaniniandroidchallenge.model.picture.PictureList

@Entity(tableName = GeneralConstants.POSTS)
data class Post(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = PostConstants.LOCAL_ID)
    val id: Int = 0,
    @ColumnInfo(name = PostConstants.TITLE)
    val title: String?,
    @ColumnInfo(name = PostConstants.VIEWS)
    val views: Int?,
    @ColumnInfo(name = PostConstants.DESCRIPTION)
    val description: String?,
    @ColumnInfo(name = PostConstants.PICTURES)
    val pictures: PictureList?
)