package io.lb.stefaniniandroidchallenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.lb.stefaniniandroidchallenge.core.GeneralConstants
import io.lb.stefaniniandroidchallenge.model.picture.Picture
import io.lb.stefaniniandroidchallenge.model.post.Post
import io.lb.stefaniniandroidchallenge.network.PostRepository
import javax.inject.Inject
import javax.security.auth.callback.Callback

class PostViewModel @Inject constructor(
    private val repository: PostRepository
): ViewModel() {
    private val pictures = MutableLiveData<ArrayList<Picture>>()

    fun loadPosts(): LiveData<List<Post>> {
        return repository.getAllRecords()
    }

    fun setupPictures(posts: List<Post>): ArrayList<Picture> {
        val pictures = arrayListOf<Picture>()
        posts.forEach {
            it.pictures?.forEach { picture ->
                if (picture != null)
                    pictures.add(picture)
            }
        }
        return pictures
    }

    fun makeApiCall(callback: () -> Unit) {
        repository.makeApiCall(GeneralConstants.CATS, callback)
    }
}