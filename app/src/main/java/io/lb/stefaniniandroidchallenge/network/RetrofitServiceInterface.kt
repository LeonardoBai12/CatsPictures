package io.lb.stefaniniandroidchallenge.network

import io.lb.stefaniniandroidchallenge.core.GeneralConstants
import io.lb.stefaniniandroidchallenge.model.post.PostEnvelope
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitServiceInterface {
    @GET(GeneralConstants.URL)
    fun getDataFromApi(
        @Header("Authorization") token: String,
        @Query("q") query: String
    ): Call<PostEnvelope>
}