package kirishhaa.viewwave.sign_up_feature.presentation.singup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.sign_up_feature.domain.CreateAccountUseCase
import kirishhaa.viewwave.sign_up_feature.presentation.SignUpRouter
import kirishhaa.viewwave.core.EmptyResult
import kirishhaa.viewwave.core.ErrorResult
import kirishhaa.viewwave.core.PendingResult
import kirishhaa.viewwave.core.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val createAccountUseCase: CreateAccountUseCase,
    private val signUpRouter: SignUpRouter
): ViewModel() {

    private val _state: MutableStateFlow<Result<Any>> = MutableStateFlow(EmptyResult())
    val state: Flow<Result<Any>> = _state

    fun onCreateAccountClicked(email: String, password: String, repeatedPassword: String) {
        viewModelScope.launch {
            _state.value = PendingResult()
            try {
                createAccountUseCase.createAccount(email, password, repeatedPassword)
                signUpRouter.goBack()
                _state.value = EmptyResult()
            } catch (e: Exception) {
                _state.value = ErrorResult(e)
            }
        }
    }

    fun onNavigateUpPressed() = signUpRouter.goBack()

}