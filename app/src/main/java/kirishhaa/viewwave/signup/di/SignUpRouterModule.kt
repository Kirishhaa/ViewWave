package kirishhaa.viewwave.signup.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kirishhaa.viewwave.sign_up_feature.presentation.SignUpRouter
import kirishhaa.viewwave.signup.SignUpRouterImpl

@Module
@InstallIn(ViewModelComponent::class)
interface SignUpRouterModule {

    @Binds
    fun bindsSignUpRouter(router: SignUpRouterImpl): SignUpRouter

}