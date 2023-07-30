package kirishhaa.viewwave.signin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kirishhaa.viewwave.sign_in_feature.presentation.SignInRouter
import kirishhaa.viewwave.signin.SignInRouterImpl

@Module
@InstallIn(ViewModelComponent::class)
interface SignInRouterModule {

    @Binds
    fun bindSignInRouter(router: SignInRouterImpl): SignInRouter

}