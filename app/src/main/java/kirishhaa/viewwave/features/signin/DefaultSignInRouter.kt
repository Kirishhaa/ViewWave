package kirishhaa.viewwave.features.signin

import kirishhaa.viewwave.main_screen.presentation.main.MainFragment
import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import kirishhaa.viewwave.sign_in_feature.presentation.SignInRouter
import kirishhaa.viewwave.sign_up_feature.presentation.singup.SignUpFragment
import javax.inject.Inject

class DefaultSignInRouter @Inject constructor(
    private val navigator: GlobalNavigator,
) : SignInRouter {

    override fun toAccountRecovery() {

    }

    override fun toSignUp() {
        navigator.navigateToFragment(
            toFragment = SignUpFragment(),
            addToBackStack = true
        )
    }

    override fun toMain() {
        navigator.navigateToFragment(
            toFragment = MainFragment(),
            addToBackStack = false
        )
    }

}