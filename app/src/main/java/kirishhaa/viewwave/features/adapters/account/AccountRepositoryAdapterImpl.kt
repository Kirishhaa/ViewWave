package kirishhaa.viewwave.features.adapters.account

import kirishhaa.viewwave.data.account.repository.AccountRepository
import kirishhaa.viewwave.sign_in_feature.data.SignInInfo
import kirishhaa.viewwave.sign_up_feature.data.SignUpInfo
import javax.inject.Inject

class AccountRepositoryAdapterImpl @Inject constructor(
    private var accountRepository: AccountRepository,
) : AccountRepositoryAdapter {

    override suspend fun signInWithEmailAndPassword(signInInfo: SignInInfo) {
        accountRepository.signInWithEmailAndPassword(signInInfo.email, signInInfo.password)
    }

    override suspend fun createUserWithEmailAndPassword(signUpInfo: SignUpInfo) {
        accountRepository.createUserWithEmailAndPassword(signUpInfo.email, signUpInfo.password)
    }

    override suspend fun isSignedIn(): Boolean {
        return accountRepository.isSignedIn()
    }


}