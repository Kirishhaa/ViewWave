package kirishhaa.viewwave.signin.usecases

import com.google.firebase.auth.FirebaseAuth
import kirishhaa.viewwave.core.BuildConfig
import kirishhaa.viewwave.core.logD
import kirishhaa.viewwave.sign_in_feature.domain.usecases.IsSignedInUseCase
import javax.inject.Inject

class FirebaseIsSignedInUseCase @Inject constructor(
    private val auth: FirebaseAuth,
) : IsSignedInUseCase {

    override suspend fun isSignedIn(): Boolean {
        val currentUser = auth.currentUser
        if (BuildConfig.DEBUG) logD(currentUser?.email ?: "currentUser = null")
        return auth.currentUser != null
    }

}