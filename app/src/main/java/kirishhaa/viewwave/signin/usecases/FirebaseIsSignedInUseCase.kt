package kirishhaa.viewwave.signin.usecases

import com.google.firebase.auth.FirebaseAuth
import kirishhaa.viewwave.sign_in_feature.domain.usecases.IsSignedInUseCase
import javax.inject.Inject

class FirebaseIsSignedInUseCase @Inject constructor(
    private val auth: FirebaseAuth
): IsSignedInUseCase {

    override suspend fun isSignedIn(): Boolean {
        return auth.currentUser!=null
    }

}