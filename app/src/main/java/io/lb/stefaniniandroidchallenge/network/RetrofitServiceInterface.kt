package io.lb.stefaniniandroidchallenge.network

import io.lb.stefaniniandroidchallenge.core.GeneralConstants
import io.lb.stefaniniandroidchallenge.model.post.PostEnvelope
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitServiceInterface {
    @GET(GeneralConstants.CATS)
    fun getDataFromApi(
        @Header("Authorization") token: String,
        @Query("id") id: String
    ): Call<PostEnvelope>
}