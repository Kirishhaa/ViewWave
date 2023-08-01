package kirishhaa.viewwave.signin

import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import kirishhaa.viewwave.sign_in_feature.presentation.SignInRouter
import kirishhaa.viewwave.sign_up_feature.presentation.singup.SignUpFragment
import javax.inject.Inject

class SignInRouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
) : SignInRouter {

    override fun toAccountRecovery() {

    }

    override fun toSingUp() {
        navigator.navigateToFragment(
            toFragment = SignUpFragment(),
            addToBackStack = true
        )
    }

    override fun toMain() {

    }

}