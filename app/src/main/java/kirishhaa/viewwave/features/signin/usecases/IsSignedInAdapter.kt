package kirishhaa.viewwave.features.signin.usecases

import kirishhaa.viewwave.data.account.repository.AccountRepository
import kirishhaa.viewwave.sign_in_feature.domain.usecases.IsSignedInUseCase
import javax.inject.Inject

class IsSignedInAdapter @Inject constructor(
    private val accountRepository: AccountRepository,
) : IsSignedInUseCase {

    override suspend fun isSignedIn(): Boolean = accountRepository.isSignedIn()

}