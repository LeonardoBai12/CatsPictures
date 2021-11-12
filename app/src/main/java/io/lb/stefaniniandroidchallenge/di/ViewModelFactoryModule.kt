package io.lb.stefaniniandroidchallenge.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.lb.stefaniniandroidchallenge.core.viewModel.ViewModelProviderFactory

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(
        providerFactory : ViewModelProviderFactory
    ) : ViewModelProvider.Factory
}