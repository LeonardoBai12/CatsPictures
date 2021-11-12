package io.lb.stefaniniandroidchallenge.di

import android.app.Application
import dagger.Module
import dagger.Provides
import io.lb.stefaniniandroidchallenge.core.db.AppDao
import io.lb.stefaniniandroidchallenge.core.db.AppDataBase
import io.lb.stefaniniandroidchallenge.core.GeneralConstants
import io.lb.stefaniniandroidchallenge.network.RetrofitServiceInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule{
    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GeneralConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getRetrofitServiceInstance(retrofit: Retrofit): RetrofitServiceInterface {
        return retrofit.create(RetrofitServiceInterface::class.java)
    }

    @Provides
    @Singleton
    fun getAppDataBase(context: Application): AppDataBase {
        return AppDataBase.getAppDataBaseInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDao(appDataBase: AppDataBase): AppDao {
        return appDataBase.getAppDao()
    }
}