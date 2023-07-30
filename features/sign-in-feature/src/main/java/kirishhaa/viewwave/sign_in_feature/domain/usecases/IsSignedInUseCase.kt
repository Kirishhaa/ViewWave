package kirishhaa.viewwave.sign_in_feature.domain.usecases

interface IsSignedInUseCase {

    suspend fun isSignedIn(): Boolean

}