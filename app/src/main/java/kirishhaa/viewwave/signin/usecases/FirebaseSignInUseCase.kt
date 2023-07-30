package kirishhaa.viewwave.signin.usecases

import com.google.firebase.auth.FirebaseAuth
import kirishhaa.viewwave.core.IncorrectPasswordException
import kirishhaa.viewwave.core.IncorrectUsernameException
import kirishhaa.viewwave.sign_in_feature.domain.usecases.SignInUseCase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseSignInUseCase @Inject constructor(
    private val auth: FirebaseAuth
): SignInUseCase {

    override suspend fun signIn(email: String, password: String) {
        if(validateEmail(email)) {
            if(validatePassword(password)) {
                val authTask = auth.signInWithEmailAndPassword(email, password)
                authTask.await()
                authTask.addOnFailureListener { throw it }
            } else {
                throw IncorrectPasswordException()
            }
        } else {
            throw IncorrectUsernameException()
        }
    }

    private fun validateEmail(email: String): Boolean {
       return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: String): Boolean {
        return password.length in (6..20)
    }

}