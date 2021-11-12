package io.lb.stefaniniandroidchallenge.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.lb.stefaniniandroidchallenge.ui.main.MainActivity

@Module
abstract class ActivityBuildersModule {

//    @ContributesAndroidInjector(
//        modules = [
//            ExampleFragmentBuildersModule::class,
//            SomethingModule::class,
//            SomethingViewModelModule::class,
//        ]
//    )
//    abstract fun contributeExampleActivity() : ExampleActivity

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}
