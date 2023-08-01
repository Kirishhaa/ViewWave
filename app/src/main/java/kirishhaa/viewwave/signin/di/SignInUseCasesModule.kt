package kirishhaa.viewwave.signin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.sign_in_feature.domain.usecases.IsSignedInUseCase
import kirishhaa.viewwave.sign_in_feature.domain.usecases.SignInUseCase
import kirishhaa.viewwave.signin.usecases.FirebaseIsSignedInUseCase
import kirishhaa.viewwave.signin.usecases.FirebaseSignInUseCase

@Module
@InstallIn(SingletonComponent::class)
interface SignInUseCasesModule {

    @Binds
    fun bindSignInUseCase(signInUseCase: FirebaseSignInUseCase): SignInUseCase

    @Binds
    fun bindIsSignedInUseCase(isSignedInUseCase: FirebaseIsSignedInUseCase): IsSignedInUseCase

}