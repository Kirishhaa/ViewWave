package kirishhaa.viewwave.sign_in_feature.presentation.singin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import dagger.hilt.android.lifecycle.HiltViewModel
import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.sign_in_feature.domain.usecases.IsSignedInUseCase
import kirishhaa.viewwave.sign_in_feature.domain.usecases.SignInUseCase
import kirishhaa.viewwave.sign_in_feature.presentation.SignInRouter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val isSignedIn: IsSignedInUseCase,
    private val signIn: SignInUseCase,
    private val router: SignInRouter): ViewModel() {

    private val _state: MutableStateFlow<Result<Any>> = MutableStateFlow(EmptyResult())
    val state: Flow<Result<Any>> = _state

    init {
        viewModelScope.launch {
            _state.value = PendingResult()
            if(isSignedIn.isSignedIn()) router.toMain()
            _state.value = EmptyResult()
        }
    }

    fun onSignInClicked(email: String, password: String) {
        viewModelScope.launch {
            _state.value = PendingResult()
            try {
                signIn.signIn(email, password)
                router.toMain()
                _state.value = EmptyResult()
            } catch (e: Exception) {
                _state.value = ErrorResult(e)
            }
        }
    }

    fun onForgetPasswordUsernameClicked() = router.toAccountRecovery()

    fun onHaventAccountClicked() = router.toSingUp()

}