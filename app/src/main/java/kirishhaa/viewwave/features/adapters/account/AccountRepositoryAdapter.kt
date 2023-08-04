package kirishhaa.viewwave.features.adapters.account

import kirishhaa.viewwave.core.AuthException
import kirishhaa.viewwave.core.CreateAccountException
import kirishhaa.viewwave.core.UnsuccessfulCreateUserException
import kirishhaa.viewwave.core.UnsuccessfulSignInException
import kirishhaa.viewwave.sign_in_feature.data.SignInInfo
import kirishhaa.viewwave.sign_up_feature.data.SignUpInfo

interface AccountRepositoryAdapter {

    /**
     * @throws AuthException - inner exception (user isn't exist, inner exception...)
     * @throws UnsuccessfulSignInException - task cancelled or blocked
     */
    suspend fun signInWithEmailAndPassword(signInInfo: SignInInfo)

    /**
     * @throws CreateAccountException - inner exception
     * @throws UnsuccessfulCreateUserException - task cancelled or blocked
     */
    suspend fun createUserWithEmailAndPassword(signUpInfo: SignUpInfo)

    /**
     * return value is is signed in user at his device
     */
    suspend fun isSignedIn(): Boolean
}