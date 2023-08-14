package kirishhaa.viewwave.navigation.usecases

import androidx.fragment.app.Fragment
import kirishhaa.viewwave.core.wrapToClassFragment
import kirishhaa.viewwave.main_screen.presentation.main.MainFragment
import kirishhaa.viewwave.navigation.domain.BaseNavigationProvider
import kirishhaa.viewwave.navigation.domain.BottomNavigationProvider
import kirishhaa.viewwave.sign_in_feature.presentation.singin.SignInFragment
import kirishhaa.viewwave.sign_up_feature.presentation.singup.SignUpFragment
import javax.inject.Inject

class NavigationProvider @Inject constructor() : BaseNavigationProvider,
    BottomNavigationProvider {

    override fun provideStartedLoggingFragment(): Class<Fragment> {
        return wrapToClassFragment(SignInFragment::class.java)
    }

    override fun provideStartedLoggingFragmentTag(): String = SignInFragment.TAG

    override fun provideHomeFragment(): Class<Fragment> {
        return wrapToClassFragment(MainFragment::class.java)
    }

    override fun provideHomeTag(): String = MainFragment.TAG

    override fun provideSearchFragment(): Class<Fragment> {
        return wrapToClassFragment(SignUpFragment::class.java)
    }

    override fun provideSearchTag(): String = SignUpFragment.TAG


}