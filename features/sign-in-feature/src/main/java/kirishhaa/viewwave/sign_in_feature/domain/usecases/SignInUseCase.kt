package kirishhaa.viewwave.sign_in_feature.domain.usecases

interface SignInUseCase {

    /**
     * throws an exception if user input incorrect data
     * if the exception wasn't thrown, user successfully signed in
    **/
    suspend fun signIn(email: String, password: String)

}