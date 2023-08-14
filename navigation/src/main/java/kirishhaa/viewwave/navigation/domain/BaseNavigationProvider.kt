package kirishhaa.viewwave.navigation.domain

import androidx.fragment.app.Fragment

interface BaseNavigationProvider {

    fun provideStartedLoggingFragment(): Class<Fragment>
    fun provideStartedLoggingFragmentTag(): String
}