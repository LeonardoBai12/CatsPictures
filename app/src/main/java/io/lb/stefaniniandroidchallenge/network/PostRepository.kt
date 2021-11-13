package io.lb.stefaniniandroidchallenge.network

import androidx.lifecycle.LiveData
import io.lb.stefaniniandroidchallenge.core.db.AppDao
import io.lb.stefaniniandroidchallenge.core.GeneralConstants
import io.lb.stefaniniandroidchallenge.model.post.Post
import io.lb.stefaniniandroidchallenge.model.post.PostEnvelope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class PostRepository (
    private val retrofitServiceInterface: RetrofitServiceInterface,
    private val appDao: AppDao
){
    fun getAllRecords(): LiveData<List<Post>> {
        return appDao.getAllRecords()
    }

    fun insertRecords(posts: Post) {
        return appDao.insertRecords(posts)
    }

    fun deleteRecords() {
        appDao.deleteAllRecords()
    }

    fun makeApiCall(query: String, callback: () -> Unit) {
        val call = retrofitServiceInterface.getDataFromApi(
            GeneralConstants.TOKEN,
            query
        )
        call.enqueue(object : Callback<PostEnvelope>{
            override fun onResponse(
                call: Call<PostEnvelope>,
                response: Response<PostEnvelope>
            ) {
                if (response.isSuccessful) {
                    CoroutineScope(Dispatchers.IO).launch {
                        deleteRecords()
                        response.body()?.data?.forEach {
                            insertRecords(it)
                        }
                        callback()
                    }
                }
            }

            override fun onFailure(call: Call<PostEnvelope>, t: Throwable) {
                Timber.e(t.toString())
            }
        })
    }
}