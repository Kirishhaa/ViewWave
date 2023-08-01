package kirishhaa.viewwave.sign_up_feature.domain

interface CreateAccountUseCase {

    /**
     * throws invalid data exceptions, if it didn't - successfully created
     * **/
    suspend fun createAccount(email: String, password: String, repeatedPassword: String)

}