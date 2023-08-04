package kirishhaa.viewwave.features.signin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.features.signin.usecases.IsSignedInAdapter
import kirishhaa.viewwave.features.signin.usecases.SignInAdapter
import kirishhaa.viewwave.sign_in_feature.domain.usecases.IsSignedInUseCase
import kirishhaa.viewwave.sign_in_feature.domain.usecases.SignInUseCase

@Module
@InstallIn(SingletonComponent::class)
interface SignInUseCasesModule {

    @Binds
    fun bindSignInUseCase(signInUseCase: SignInAdapter): SignInUseCase

    @Binds
    fun bindIsSignedInUseCase(isSignedInUseCase: IsSignedInAdapter): IsSignedInUseCase

}