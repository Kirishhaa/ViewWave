package kirishhaa.viewwave.data.account.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.data.account.repository.AccountRepository
import kirishhaa.viewwave.data.account.repository.DefaultAccountRepository

@Module
@InstallIn(SingletonComponent::class)
interface AccountRepositoryModule {

    @Binds
    fun bindAccountRepository(repo: DefaultAccountRepository): AccountRepository

}