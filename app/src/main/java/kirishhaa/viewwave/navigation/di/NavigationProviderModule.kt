package kirishhaa.viewwave.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import kirishhaa.viewwave.navigation.domain.NavigationProvider
import kirishhaa.viewwave.navigation.presentation.GlobalTransactionNavigator
import kirishhaa.viewwave.navigation.usecases.NavigationProviderImpl


@Module
@InstallIn(SingletonComponent::class)
interface NavigationProviderModule {

    @Binds
    fun bindGlobalNavigator(navigator: GlobalTransactionNavigator): GlobalNavigator

    @Binds
    fun provideStartedFragmentClass(provider: NavigationProviderImpl): NavigationProvider

}