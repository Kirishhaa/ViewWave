package kirishhaa.viewwave.navigation.domain

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Navigator based on fragments tags and fragments stack
 * Provide navigation between fragments and activities
 * Every navigated fragment must have a tag
 */
interface BaseNavigator {

    fun navigateToActivity(toActivityClass: Class<out FragmentActivity>)

    fun navigateToFragment(
        toFragment: Fragment,
        tag: String,
    )

    fun goBack()

}