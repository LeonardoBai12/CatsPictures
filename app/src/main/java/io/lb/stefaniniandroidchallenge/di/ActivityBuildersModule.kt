package io.lb.stefaniniandroidchallenge.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.lb.stefaniniandroidchallenge.di.post.PostModule
import io.lb.stefaniniandroidchallenge.di.post.PostViewModelModule
import io.lb.stefaniniandroidchallenge.ui.main.MainActivity
import io.lb.stefaniniandroidchallenge.ui.main.PostViewModel

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(
        modules = [
            PostModule::class,
            PostViewModelModule::class,
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
