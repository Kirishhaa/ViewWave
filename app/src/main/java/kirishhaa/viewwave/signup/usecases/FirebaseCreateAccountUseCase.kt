package kirishhaa.viewwave.signup.usecases

import com.google.firebase.auth.FirebaseAuth
import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.sign_up_feature.domain.CreateAccountUseCase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseCreateAccountUseCase @Inject constructor(
    private val auth: FirebaseAuth,
) : CreateAccountUseCase {

    override suspend fun createAccount(email: String, password: String, repeatedPassword: String) {
        if (email.isValidateEmail()) {
            if (password.isValidatePassword()) {
                if (password == repeatedPassword) {
                    val createAccTask = auth.createUserWithEmailAndPassword(email, password)
                    createAccTask.await()
                    createAccTask.addOnFailureListener { throw it }
                } else {
                    throw PasswordsMatchException()
                }
            } else {
                throw IncorrectPasswordException()
            }
        } else {
            throw IncorrectEmailException()
        }
    }
}