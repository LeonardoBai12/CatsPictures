package io.lb.stefaniniandroidchallenge.di.post

import dagger.Module
import dagger.Provides
import io.lb.stefaniniandroidchallenge.core.db.AppDao
import io.lb.stefaniniandroidchallenge.network.PostRepository
import io.lb.stefaniniandroidchallenge.network.RetrofitServiceInterface

@Module
class PostModule {
    @Provides
    fun providesPostsRepository(
        retrofitServiceInterface: RetrofitServiceInterface,
        appDao: AppDao
    ): PostRepository {
        return PostRepository(retrofitServiceInterface, appDao)
    }
}