package kirishhaa.viewwave.features.adapters.account

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AccountRepositoryAdapterModule {

    @Binds
    fun bindAccountRepositoryAdapter(adapterImpl: AccountRepositoryAdapterImpl): AccountRepositoryAdapter

}