package kirishhaa.viewwave.signup.di

import com.example.sign_up_feature.domain.CreateAccountUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kirishhaa.viewwave.signup.usecases.FirebaseCreateAccountUseCase

@Module
@InstallIn(ViewModelComponent::class)
interface CreateAccountUseCasesModule {

    @Binds
    fun bindCreateAccountUseCase(createAccountUseCase: FirebaseCreateAccountUseCase): CreateAccountUseCase
}