package kirishhaa.viewwave.features.signin

import kirishhaa.viewwave.navigation.domain.BaseNavigator
import kirishhaa.viewwave.navigation.presentation.MainActivity
import kirishhaa.viewwave.sign_in_feature.presentation.SignInRouter
import kirishhaa.viewwave.sign_up_feature.presentation.singup.SignUpFragment
import javax.inject.Inject

class DefaultSignInRouter @Inject constructor(
    private val navigator: BaseNavigator,
) : SignInRouter {

    override fun toAccountRecovery() {

    }

    override fun toSignUp() {
        navigator.navigateToFragment(
            toFragment = SignUpFragment(),
            SignUpFragment.TAG
        )
    }

    override fun toMain() {
        navigator.navigateToActivity(
            MainActivity::class.java
        )
    }

}