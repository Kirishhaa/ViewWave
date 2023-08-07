package kirishhaa.viewwave.sign_up_feature.presentation.singup

import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.core.BaseViewModel
import kirishhaa.viewwave.core.Finish
import kirishhaa.viewwave.core.PendingFinish
import kirishhaa.viewwave.sign_up_feature.data.SignUpInfo
import kirishhaa.viewwave.sign_up_feature.domain.CreateAccountUseCase
import kirishhaa.viewwave.sign_up_feature.presentation.SignUpRouter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val createAccountUseCase: CreateAccountUseCase,
    private val signUpRouter: SignUpRouter,
) : BaseViewModel() {

    private val _state: MutableStateFlow<Finish<Unit>> = MutableStateFlow(PendingFinish())
    val state: Flow<Finish<Unit>> = _state

    fun onCreateAccountClicked(email: String, password: String, repeatedPassword: String) {
        handleFinishFlow(_state) {
            val signUpInfo = SignUpInfo(email, password, repeatedPassword)
            createAccountUseCase.createAccount(signUpInfo)
            signUpRouter.goBack()
        }
    }

    fun onNavigateUpPressed() = signUpRouter.goBack()

}