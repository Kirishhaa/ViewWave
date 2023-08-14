package kirishhaa.viewwave.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.navigation.domain.BaseNavigationProvider
import kirishhaa.viewwave.navigation.domain.BottomNavigationProvider
import kirishhaa.viewwave.navigation.usecases.NavigationProvider


@Module
@InstallIn(SingletonComponent::class)
interface NavigationProviderModule {

    @Binds
    fun bindBaseNavigationProvider(provider: NavigationProvider): BaseNavigationProvider

    @Binds
    fun bindBottomNavigationProvider(provider: NavigationProvider): BottomNavigationProvider

}