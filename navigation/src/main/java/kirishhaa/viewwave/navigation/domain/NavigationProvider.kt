package kirishhaa.viewwave.navigation.domain

import androidx.fragment.app.Fragment

interface NavigationProvider {

    fun provideStartedFragmentClass(): Class<Fragment>

}