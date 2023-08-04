package kirishhaa.viewwave.data.account.repository

import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.data.account.datasource.AccountDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultAccountRepository @Inject constructor(
    private val accountDataSource: AccountDataSource
): AccountRepository {

    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        try {
            val isSuccessful = accountDataSource.signInWithEmailAndPassword(email, password)
            if(!isSuccessful) {
                logE("signInWithEmailAndPassword unsuccessful exception")
                throw UnsuccessfulSignInException()
            }
        }catch (e: AuthException) {
            logE("signInWithEmailAndPassword auth exception")
            throw e
        }
    }

    override suspend fun isSignedIn(): Boolean = accountDataSource.isSignedIn()

    override suspend fun createUserWithEmailAndPassword(email: String, password: String) {
        try {
            val isSuccessful = accountDataSource.createUserWithEmailAndPassword(email, password)
            if(!isSuccessful) {
                logE("createUserWithEmailAndPassword unsuccessful exception")
                throw UnsuccessfulCreateUserException()
            }
        } catch (e: CreateAccountException) {
            logE("createUserWithEmailAndPassword create account exception")
            throw e
        }
    }

}