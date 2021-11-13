package io.lb.stefaniniandroidchallenge.model.picture

import com.google.gson.annotations.SerializedName

class Picture(
    @field:SerializedName(PictureConstants.URL)
    val url: String
)