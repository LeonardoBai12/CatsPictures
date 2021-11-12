package io.lb.stefaniniandroidchallenge.ui.main

import androidx.lifecycle.ViewModel
import io.lb.stefaniniandroidchallenge.network.PostRepository
import javax.inject.Inject

class PostViewModel @Inject constructor(
    private val repository: PostRepository
): ViewModel() {
}