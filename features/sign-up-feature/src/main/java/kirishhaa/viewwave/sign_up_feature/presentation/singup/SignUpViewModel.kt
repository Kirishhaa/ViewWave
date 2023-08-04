package kirishhaa.viewwave.sign_up_feature.presentation.singup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.sign_up_feature.domain.CreateAccountUseCase
import kirishhaa.viewwave.sign_up_feature.presentation.SignUpRouter
import kirishhaa.viewwave.sign_up_feature.data.SignUpInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val createAccountUseCase: CreateAccountUseCase,
    private val signUpRouter: SignUpRouter
): ViewModel() {

    private val _state: MutableStateFlow<Finish<Unit>> = MutableStateFlow(EmptyFinish())
    val state: Flow<Finish<Unit>> = _state

    fun onCreateAccountClicked(email: String, password: String, repeatedPassword: String) {
        handleSingleFinishEvent(_state) {
            val signUpInfo = SignUpInfo(email, password, repeatedPassword)
            createAccountUseCase.createAccount(signUpInfo)
            signUpRouter.goBack()
        }
    }

    fun onNavigateUpPressed() = signUpRouter.goBack()

}