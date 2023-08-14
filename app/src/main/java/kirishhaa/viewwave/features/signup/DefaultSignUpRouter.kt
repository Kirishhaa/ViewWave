package kirishhaa.viewwave.features.signup

import kirishhaa.viewwave.navigation.domain.BaseNavigator
import kirishhaa.viewwave.sign_up_feature.presentation.SignUpRouter
import javax.inject.Inject

class DefaultSignUpRouter @Inject constructor(
    private val navigator: BaseNavigator,
) : SignUpRouter {

    override fun goBack() = navigator.goBack()

}