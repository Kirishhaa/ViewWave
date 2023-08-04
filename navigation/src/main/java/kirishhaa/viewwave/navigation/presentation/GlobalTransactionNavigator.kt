package kirishhaa.viewwave.navigation.presentation

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import kirishhaa.viewwave.navigation.R
import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import javax.inject.Inject

internal class GlobalTransactionNavigator @Inject constructor(
    private val activityLifecycleExecutor: ActivityLifecycleExecutor,
) : GlobalNavigator {

    override fun navigateToActivity(
        toActivityClass: Class<FragmentActivity>,
    ) = activityLifecycleExecutor.execute {
        val intent = Intent(it, toActivityClass)
        it.startActivity(intent)
    }

    override fun navigateToFragment(
        toFragment: Fragment,
        addToBackStack: Boolean,
    ) = activityLifecycleExecutor.execute {
        val fragmentManager = it.supportFragmentManager
        navigateFragmentImpl(fragmentManager, toFragment, R.id.fragmentContainer, addToBackStack)
    }

    override fun goBack() = activityLifecycleExecutor.execute {
        it.onBackPressed()
    }

    private fun navigateFragmentImpl(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        containerId: Int,
        addToBackStack: Boolean,
    ) {
        val tr = fragmentManager.beginTransaction()
            .replace(containerId, fragment)
        if (addToBackStack) tr.addToBackStack(null)
        tr.commit()
    }

}