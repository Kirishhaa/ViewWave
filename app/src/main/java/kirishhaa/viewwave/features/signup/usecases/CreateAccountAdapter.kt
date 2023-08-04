package kirishhaa.viewwave.features.signup.usecases

import kirishhaa.viewwave.core.IncorrectEmailException
import kirishhaa.viewwave.core.IncorrectPasswordException
import kirishhaa.viewwave.core.PasswordsMatchException
import kirishhaa.viewwave.features.adapters.account.AccountRepositoryAdapter
import kirishhaa.viewwave.sign_up_feature.data.SignUpInfo
import kirishhaa.viewwave.sign_up_feature.domain.CreateAccountUseCase
import kirishhaa.viewwave.utils.validator.AccountValidator
import javax.inject.Inject

class CreateAccountAdapter @Inject constructor(
    private val accountRepositoryAdapter: AccountRepositoryAdapter,
) : CreateAccountUseCase {

    private val accountValidator = AccountValidator.getInstance()

    override suspend fun createAccount(signUpInfo: SignUpInfo) {
        val email = signUpInfo.email
        if (accountValidator.validateEmail(email)) {
            val password = signUpInfo.password
            if (accountValidator.validatePassword(password)) {
                val repeatedPassword = signUpInfo.repeatedPassword
                if (password == repeatedPassword) {
                    try {
                        accountRepositoryAdapter.createUserWithEmailAndPassword(signUpInfo)
                    } catch (e: Exception) {
                        //CreateAccountException or UnsuccessfulCreateAccountException
                        throw e
                    }
                } else {
                    throw PasswordsMatchException()
                }
            } else {
                throw IncorrectPasswordException()
            }
        } else {
            throw IncorrectEmailException()
        }
    }
}