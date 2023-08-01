package kirishhaa.viewwave.signup.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kirishhaa.viewwave.sign_up_feature.domain.CreateAccountUseCase
import kirishhaa.viewwave.signup.usecases.FirebaseCreateAccountUseCase

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAccountUseCasesModule {

    @Binds
    fun bindCreateAccountUseCase(createAccountUseCase: FirebaseCreateAccountUseCase): CreateAccountUseCase
}