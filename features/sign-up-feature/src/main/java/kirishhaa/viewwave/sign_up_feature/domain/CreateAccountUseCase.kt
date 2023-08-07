package kirishhaa.viewwave.sign_up_feature.domain

import kirishhaa.viewwave.core.*
import kirishhaa.viewwave.sign_up_feature.data.SignUpInfo

interface CreateAccountUseCase {

    /**
     * Check input data(email, password, repeatedPassword) and create a user by email and password.
     * @throws IncorrectEmailException - invalid email or email format
     * @throws IncorrectPasswordException - invalid password or password format
     * @throws PasswordsMatchException - password doesn't match to repeated
     * @throws UnsuccessfulCreateUserException - task was cancelled or blocked
     * @throws AuthException - inner exception (for instance, user isn't in db)
     */
    suspend fun createAccount(signUpInfo: SignUpInfo)

}