package kirishhaa.viewwave.navigation.domain

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kirishhaa.viewwave.navigation.R
import javax.inject.Inject


internal class TransactionNavigator @Inject constructor(
    private val activityLifecycleExecutor: ActivityLifecycleExecutor,
    private val tagFragmentManager: TagFragmentManager
) : BaseNavigator, BottomNavigator {

    override fun navigateToActivity(toActivityClass: Class<out FragmentActivity>) =
        activityLifecycleExecutor.execute { activity ->
            val intent = Intent(activity, toActivityClass)
            activity.startActivity(intent)
            activity.finish()
        }

    override fun navigateToFragment(toFragment: Fragment, tag: String) =
        activityLifecycleExecutor.execute { activity ->
            activity.supportFragmentManager.popBackStack(tag, 0)
            val transaction = activity.supportFragmentManager.beginTransaction()
            transaction
                .addToBackStack(tag)
                .replace(R.id.fragmentContainer, toFragment, tag)
                .commit()
        }

    override fun goBack() = activityLifecycleExecutor.execute { activity ->
        activity.onNavigateUp()
    }

    override fun navigateToFragment(parentTag: String, fragmentTag: String, toFragment: Fragment) {
        tagFragmentManager.putFragmentByTag(parentTag, fragmentTag)
        navigateToFragment(toFragment, fragmentTag)
    }

}