package kirishhaa.viewwave.sign_in_feature.domain.usecases

interface IsSignedInUseCase {

    /**
     * return value is is signed in user at his device
     */
    suspend fun isSignedIn(): Boolean

}