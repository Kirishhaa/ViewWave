package kirishhaa.viewwave.features.signup.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kirishhaa.viewwave.features.signup.DefaultSignUpRouter
import kirishhaa.viewwave.sign_up_feature.presentation.SignUpRouter

@Module
@InstallIn(ViewModelComponent::class)
interface SignUpRouterModule {

    @Binds
    fun bindsSignUpRouter(router: DefaultSignUpRouter): SignUpRouter

}