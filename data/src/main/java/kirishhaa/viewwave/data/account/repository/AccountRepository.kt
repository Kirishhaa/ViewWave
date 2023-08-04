package kirishhaa.viewwave.data.account.repository

import kirishhaa.viewwave.core.CreateAccountException
import kirishhaa.viewwave.core.UnsuccessfulCreateUserException
import kirishhaa.viewwave.core.AuthException
import kirishhaa.viewwave.core.UnsuccessfulSignInException

interface AccountRepository {

    /**
     * @throws AuthException - inner exception (user isn't exist, inner exception...)
     * @throws UnsuccessfulSignInException - task cancelled or blocked
     */
    suspend fun signInWithEmailAndPassword(email: String, password: String)

    /**
     * @throws CreateAccountException - inner exception
     * @throws UnsuccessfulCreateUserException - task cancelled or blocked
     */
    suspend fun createUserWithEmailAndPassword(email: String, password: String)

    /**
     * return value is is signed in user at his device
     */
    suspend fun isSignedIn(): Boolean
}