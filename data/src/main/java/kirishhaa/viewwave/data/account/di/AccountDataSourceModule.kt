package kirishhaa.viewwave.data.account.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.data.account.datasource.AccountDataSource
import kirishhaa.viewwave.data.account.datasource.FirebaseDataSource

@Module
@InstallIn(SingletonComponent::class)
internal interface AccountDataSourceModule {

    @Binds
    fun bindAccountDataSource(ads: FirebaseDataSource): AccountDataSource

}