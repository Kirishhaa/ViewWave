package kirishhaa.viewwave.sign_in_feature.domain.usecases

import kirishhaa.viewwave.core.IncorrectEmailException
import kirishhaa.viewwave.core.IncorrectPasswordException
import kirishhaa.viewwave.core.AuthException
import kirishhaa.viewwave.core.UnsuccessfulSignInException
import kirishhaa.viewwave.sign_in_feature.data.SignInInfo

interface SignInUseCase {

    /**
     * SignIn a user by email and password. (into db)
     * @throws IncorrectEmailException - invalid email or email format
     * @throws IncorrectPasswordException - invalid password or password format
     * @throws UnsuccessfulSignInException - task was cancelled or blocked
     * @throws AuthException - inner exception (for instance, user isn't in db)
    */
    suspend fun signIn(signInInfo: SignInInfo)

}