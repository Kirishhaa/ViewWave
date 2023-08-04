package kirishhaa.viewwave.navigation.usecases

import androidx.fragment.app.Fragment
import kirishhaa.viewwave.core.wrapToClassFragment
import kirishhaa.viewwave.navigation.domain.NavigationProvider
import kirishhaa.viewwave.sign_in_feature.presentation.singin.SignInFragment
import javax.inject.Inject

class DefaultNavigationProvider @Inject constructor() : NavigationProvider {

    override fun provideStartedFragmentClass(): Class<Fragment> {
        return wrapToClassFragment(SignInFragment::class.java)
    }

}