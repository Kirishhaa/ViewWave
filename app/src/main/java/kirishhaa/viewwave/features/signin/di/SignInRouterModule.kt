package kirishhaa.viewwave.features.signin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kirishhaa.viewwave.features.signin.DefaultSignInRouter
import kirishhaa.viewwave.sign_in_feature.presentation.SignInRouter

@Module
@InstallIn(ViewModelComponent::class)
interface SignInRouterModule {

    @Binds
    fun bindSignInRouter(router: DefaultSignInRouter): SignInRouter

}