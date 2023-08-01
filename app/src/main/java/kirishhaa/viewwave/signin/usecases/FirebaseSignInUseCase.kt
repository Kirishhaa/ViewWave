package kirishhaa.viewwave.signin.usecases

import com.google.firebase.auth.FirebaseAuth
import kirishhaa.viewwave.core.IncorrectEmailException
import kirishhaa.viewwave.core.IncorrectPasswordException
import kirishhaa.viewwave.core.isValidateEmail
import kirishhaa.viewwave.core.isValidatePassword
import kirishhaa.viewwave.sign_in_feature.domain.usecases.SignInUseCase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseSignInUseCase @Inject constructor(
    private val auth: FirebaseAuth,
) : SignInUseCase {

    override suspend fun signIn(email: String, password: String) {
        if (email.isValidateEmail()) {
            if (password.isValidatePassword()) {
                val authTask = auth.signInWithEmailAndPassword(email, password)
                authTask.await()
                authTask.addOnFailureListener { throw it }
            } else {
                throw IncorrectPasswordException()
            }
        } else {
            throw IncorrectEmailException()
        }
    }

}