package kirishhaa.viewwave.sign_in_feature.presentation.singin

import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.core.BaseViewModel
import kirishhaa.viewwave.core.Finish
import kirishhaa.viewwave.core.PendingFinish
import kirishhaa.viewwave.sign_in_feature.data.SignInInfo
import kirishhaa.viewwave.sign_in_feature.domain.usecases.IsSignedInUseCase
import kirishhaa.viewwave.sign_in_feature.domain.usecases.SignInUseCase
import kirishhaa.viewwave.sign_in_feature.presentation.SignInRouter
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val isSignedIn: IsSignedInUseCase,
    private val signIn: SignInUseCase,
    private val router: SignInRouter,
) : BaseViewModel() {

    private val _state: MutableStateFlow<Finish<Unit>> = MutableStateFlow(PendingFinish())
    val state: Flow<Finish<Unit>> = _state

    init {
        handleFinishFlow(_state) {
            delay(1000)
            if (isSignedIn.isSignedIn()) router.toMain()
        }
    }

    fun onSignInClicked(email: String, password: String) {
        handleFinishFlow(_state) {
            val signInInfo = SignInInfo(email, password)
            signIn.signIn(signInInfo)
            router.toMain()
        }
    }

    fun onForgetPasswordUsernameClicked() = router.toAccountRecovery()

    fun onHaventAccountClicked() = router.toSignUp()

}