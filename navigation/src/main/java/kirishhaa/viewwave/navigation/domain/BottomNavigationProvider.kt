package kirishhaa.viewwave.navigation.domain

import androidx.fragment.app.Fragment

interface BottomNavigationProvider {

    fun provideHomeFragment(): Class<Fragment>
    fun provideHomeTag(): String

    fun provideSearchFragment(): Class<Fragment>
    fun provideSearchTag(): String

}