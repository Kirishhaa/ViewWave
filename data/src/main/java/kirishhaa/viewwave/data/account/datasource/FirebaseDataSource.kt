package kirishhaa.viewwave.data.account.datasource

import com.google.firebase.auth.FirebaseAuth
import kirishhaa.viewwave.core.AuthException
import kirishhaa.viewwave.core.CreateAccountException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseDataSource @Inject constructor(
    private val auth: FirebaseAuth
): AccountDataSource {

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Boolean {
        val task = auth.signInWithEmailAndPassword(email, password)
        task.await()
        task.addOnFailureListener { firebaseException  ->  throw AuthException(firebaseException) }
        return task.isSuccessful
    }

    override suspend fun isSignedIn(): Boolean = auth.currentUser!=null


    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Boolean {
        val task = auth.createUserWithEmailAndPassword(email, password)
        task.await()
        task.addOnFailureListener { firebaseException -> throw CreateAccountException(firebaseException) }
        return task.isSuccessful
    }

}