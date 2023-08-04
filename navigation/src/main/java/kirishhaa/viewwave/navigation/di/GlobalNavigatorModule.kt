package kirishhaa.viewwave.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import kirishhaa.viewwave.navigation.presentation.GlobalTransactionNavigator

@Module
@InstallIn(SingletonComponent::class)
internal interface GlobalNavigatorModule {

    @Binds
    fun bindGlobalNavigator(navigator: GlobalTransactionNavigator): GlobalNavigator

}