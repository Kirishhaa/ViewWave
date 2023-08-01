package kirishhaa.viewwave.navigation.domain

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

interface GlobalNavigator {

    fun navigateToActivity(toActivityClass: Class<FragmentActivity>)

    fun navigateToFragment(
        toFragment: Fragment,
        addToBackStack: Boolean = true,
    )

    fun goBack()

}