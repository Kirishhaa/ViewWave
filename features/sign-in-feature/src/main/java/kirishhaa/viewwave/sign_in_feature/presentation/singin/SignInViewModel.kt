package kirishhaa.viewwave.sign_in_feature.presentation.singin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.core.EmptyFinish
import kirishhaa.viewwave.core.Finish
import kirishhaa.viewwave.core.handleSingleFinishEvent
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
) : ViewModel() {

    private val _state: MutableStateFlow<Finish<Unit>> = MutableStateFlow(EmptyFinish())
    val state: Flow<Finish<Unit>> = _state

    init {
        handleSingleFinishEvent(_state) {
            delay(2000)
            if (isSignedIn.isSignedIn()) router.toMain()
        }
    }

    fun onSignInClicked(email: String, password: String) {
        handleSingleFinishEvent(_state) {
            val signInInfo = SignInInfo(email, password)
            signIn.signIn(signInInfo)
            router.toMain()
        }
    }

    fun onForgetPasswordUsernameClicked() = router.toAccountRecovery()

    fun onHaventAccountClicked() = router.toSignUp()

}