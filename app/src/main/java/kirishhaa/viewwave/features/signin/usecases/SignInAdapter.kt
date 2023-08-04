package kirishhaa.viewwave.features.signin.usecases

import kirishhaa.viewwave.core.IncorrectEmailException
import kirishhaa.viewwave.core.IncorrectPasswordException
import kirishhaa.viewwave.data.account.repository.AccountRepository
import kirishhaa.viewwave.sign_in_feature.data.SignInInfo
import kirishhaa.viewwave.sign_in_feature.domain.usecases.SignInUseCase
import kirishhaa.viewwave.utils.validator.AccountValidator
import javax.inject.Inject

class SignInAdapter @Inject constructor(
    private val signInRepo: AccountRepository,
) : SignInUseCase {

    private val accountValidator = AccountValidator.getInstance()

    override suspend fun signIn(signInInfo: SignInInfo) {
        val email = signInInfo.email
        if (accountValidator.validateEmail(email)) {
            val password = signInInfo.password
            if (accountValidator.validatePassword(password)) {
                try {
                    signInRepo.signInWithEmailAndPassword(email, password)
                } catch (e: Exception) {
                    //Unsuccessful or Auth exception
                    throw e
                }
            } else {
                throw IncorrectPasswordException()
            }
        } else {
            throw IncorrectEmailException()
        }
    }

}