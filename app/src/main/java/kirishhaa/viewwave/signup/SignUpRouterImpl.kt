package kirishhaa.viewwave.signup

import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import kirishhaa.viewwave.sign_up_feature.presentation.SignUpRouter
import javax.inject.Inject

class SignUpRouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
) : SignUpRouter {

    override fun goBack() = navigator.goBack()

}