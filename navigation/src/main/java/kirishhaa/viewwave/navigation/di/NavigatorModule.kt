package kirishhaa.viewwave.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.navigation.domain.BaseNavigator
import kirishhaa.viewwave.navigation.domain.BottomNavigator
import kirishhaa.viewwave.navigation.domain.TransactionNavigator

@Module
@InstallIn(SingletonComponent::class)
internal interface NavigatorModule {

    @Binds
    fun bindBaseNavigator(navigator: TransactionNavigator): BaseNavigator

    @Binds
    fun bindBottomNavigator(navigator: TransactionNavigator): BottomNavigator

}