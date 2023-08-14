package kirishhaa.viewwave.data.account.datasource

import com.google.firebase.auth.FirebaseAuth
import kirishhaa.viewwave.core.AuthException
import kirishhaa.viewwave.core.CreateAccountException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseDataSource @Inject constructor(
    private val auth: FirebaseAuth,
) : AccountDataSource {

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val task = auth.signInWithEmailAndPassword(email, password)
            task.await()
            task.addOnFailureListener { firebaseException -> throw AuthException(firebaseException) }
            return@withContext task.isSuccessful
        }
    }

    override suspend fun isSignedIn(): Boolean {
        return withContext(Dispatchers.IO) {
            return@withContext auth.currentUser != null
        }
    }


    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val task = auth.createUserWithEmailAndPassword(email, password)
            task.await()
            task.addOnFailureListener { firebaseException ->
                throw CreateAccountException(
                    firebaseException
                )
            }
            return@withContext task.isSuccessful
        }
    }

}