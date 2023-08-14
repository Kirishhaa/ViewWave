package kirishhaa.viewwave.navigation.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.navigation.R
import kirishhaa.viewwave.navigation.domain.ActivityLifecycleExecutor
import kirishhaa.viewwave.navigation.domain.BottomNavigationProvider
import kirishhaa.viewwave.navigation.domain.BottomNavigator
import kirishhaa.viewwave.navigation.domain.TagFragmentManager
import javax.inject.Inject

/**
 * The Activity using for mapping cinema fragments with bottomNavigation
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val bottomNavigation by lazy<BottomNavigationView> { findViewById(R.id.bottomNavigation) }


    @Inject
    internal lateinit var tagFragmentManager: TagFragmentManager

    @Inject
    internal lateinit var activityLifecycleExecutor: ActivityLifecycleExecutor

    @Inject
    internal lateinit var bottomNavigationProvider: BottomNavigationProvider

    @Inject
    internal lateinit var navigator: BottomNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            navigateStackFragment(
                parentTag = bottomNavigationProvider.provideHomeTag(),
                getBaseFragment = bottomNavigationProvider::provideHomeFragment
            )
        }

        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    navigateStackFragment(
                        parentTag = bottomNavigationProvider.provideHomeTag(),
                        getBaseFragment = bottomNavigationProvider::provideHomeFragment
                    )
                    true
                }
                R.id.action_search -> {
                    navigateStackFragment(
                        parentTag = bottomNavigationProvider.provideSearchTag(),
                        getBaseFragment = bottomNavigationProvider::provideSearchFragment
                    )
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateStackFragment(
        parentTag: String,
        getBaseFragment: (() -> Class<Fragment>)?,
    ) {

        val stackFragments = tagFragmentManager.getFragmentStack(parentTag)

        if (stackFragments.isNotEmpty()) {
            moveToFragment(parentTag, stackFragments.last(), getBaseFragment)
        } else {
            moveToFragment(parentTag, parentTag, getBaseFragment)
        }
    }

    private fun moveToFragment(
        parentTag: String,
        fragmentTag: String,
        getBaseFragment: (() -> Class<Fragment>)?,
    ) {
        val stackedFragment: Fragment? =
            supportFragmentManager.findFragmentByTag(fragmentTag)
        val searchFragment =
            stackedFragment ?: getBaseFragment?.invoke()?.newInstance()
            ?: throw IllegalStateException()

        navigator.navigateToFragment(
            parentTag = parentTag,
            fragmentTag = fragmentTag,
            toFragment = searchFragment
        )
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.getOrNull(0)?.let { fragment ->
            val parentTag = tagFragmentManager.getParentTag(fragment.tag)
            if (parentTag == null) {
                finish()
            } else {
                val stack = tagFragmentManager.getFragmentStack(parentTag)
                if (stack.size == 1) {
                    finish()
                } else {
                    tagFragmentManager.removeChildTag(fragment.tag, parentTag)
                    navigateStackFragment(parentTag, null)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        activityLifecycleExecutor.registerActivity(this)
    }

    override fun onPause() {
        super.onPause()
        activityLifecycleExecutor.unregisterActivity()
    }

}