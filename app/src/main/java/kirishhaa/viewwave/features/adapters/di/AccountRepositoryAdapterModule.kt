package kirishhaa.viewwave.features.adapters.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.features.adapters.account.AccountRepositoryAdapter
import kirishhaa.viewwave.features.adapters.account.AccountRepositoryAdapterImpl

@Module
@InstallIn(SingletonComponent::class)
interface AccountRepositoryAdapterModule {

    @Binds
    fun bindAccountRepositoryAdapter(adapterImpl: AccountRepositoryAdapterImpl): AccountRepositoryAdapter

}