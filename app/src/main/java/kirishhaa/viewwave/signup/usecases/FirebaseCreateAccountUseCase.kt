package kirishhaa.viewwave.signup.usecases

import com.example.sign_up_feature.domain.CreateAccountUseCase

class FirebaseCreateAccountUseCase: CreateAccountUseCase {

    override suspend fun createAccount(email: String, password: String, repeatedPassword: String) {
        TODO("Not yet implemented")
    }
}