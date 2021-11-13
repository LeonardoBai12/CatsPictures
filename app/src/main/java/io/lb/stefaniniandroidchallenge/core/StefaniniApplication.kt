package io.lb.stefaniniandroidchallenge.core

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.lb.stefaniniandroidchallenge.BuildConfig
import io.lb.stefaniniandroidchallenge.di.DaggerAppComponent
import timber.log.Timber

class StefaniniApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        return DaggerAppComponent.builder().application(this).build()
    }
}