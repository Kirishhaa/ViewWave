package kirishhaa.viewwave.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.navigation.domain.NavigationProvider
import kirishhaa.viewwave.navigation.usecases.DefaultNavigationProvider


@Module
@InstallIn(SingletonComponent::class)
interface NavigationProviderModule {

    @Binds
    fun provideStartedFragmentClass(provider: DefaultNavigationProvider): NavigationProvider

}