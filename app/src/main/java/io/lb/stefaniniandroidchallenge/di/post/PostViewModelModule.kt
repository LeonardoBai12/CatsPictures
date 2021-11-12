package io.lb.stefaniniandroidchallenge.di.post

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.lb.stefaniniandroidchallenge.di.ViewModelKey
import io.lb.stefaniniandroidchallenge.ui.main.PostViewModel

@Module
abstract class PostViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(viewModel: PostViewModel) : ViewModel
}