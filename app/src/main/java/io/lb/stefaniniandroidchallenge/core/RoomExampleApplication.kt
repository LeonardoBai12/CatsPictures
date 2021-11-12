package io.lb.stefaniniandroidchallenge.core

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.lb.stefaniniandroidchallenge.di.DaggerAppComponent

class StefaniniApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}