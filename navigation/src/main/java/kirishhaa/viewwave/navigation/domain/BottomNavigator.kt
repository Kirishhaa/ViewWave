package kirishhaa.viewwave.navigation.domain

import androidx.fragment.app.Fragment

/**
 * Navigator based on fragments tags and fragments stack for BottomNavigationView
 * parentTag is a started fragment tag in BottomNavigationView's page
 * fragmentTag is fragment tag that we want to set into the page
 * toFragment is an instance of fragment
 * Every navigated fragment must have a tag and a parent tag
 */
interface BottomNavigator {

    fun navigateToFragment(parentTag: String, fragmentTag: String, toFragment: Fragment)
}