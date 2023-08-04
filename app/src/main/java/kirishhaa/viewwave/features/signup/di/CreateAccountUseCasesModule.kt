package kirishhaa.viewwave.features.signup.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kirishhaa.viewwave.features.signup.usecases.CreateAccountAdapter
import kirishhaa.viewwave.sign_up_feature.domain.CreateAccountUseCase

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAccountUseCasesModule {

    @Binds
    fun bindCreateAccountUseCase(createAccountUseCase: CreateAccountAdapter): CreateAccountUseCase
}