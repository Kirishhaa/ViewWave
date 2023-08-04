package kirishhaa.viewwave.data.account.datasource

import kirishhaa.viewwave.core.AuthException
import kirishhaa.viewwave.core.CreateAccountException

interface AccountDataSource {

    /**
     * @throws AuthException
     * return value is successful sign in
     */
    suspend fun signInWithEmailAndPassword(email: String, password: String): Boolean

    /**
     * @throws CreateAccountException
     * return value is successful created user
     */
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Boolean

    /**
     * return value is is signed in user at his device
     */
    suspend fun isSignedIn(): Boolean

}