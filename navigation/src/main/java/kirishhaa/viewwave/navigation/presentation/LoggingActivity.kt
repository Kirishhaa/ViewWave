package kirishhaa.viewwave.navigation.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.navigation.R
import kirishhaa.viewwave.navigation.domain.ActivityLifecycleExecutor
import kirishhaa.viewwave.navigation.domain.BaseNavigationProvider
import kirishhaa.viewwave.navigation.domain.BaseNavigator
import javax.inject.Inject

/**
 * The Activity using for signIn and signUp features
 */
@AndroidEntryPoint
class LoggingActivity : AppCompatActivity() {

    @Inject
    internal lateinit var executor: ActivityLifecycleExecutor

    @Inject
    lateinit var navigator: BaseNavigator

    @Inject
    lateinit var baseNavigationProvider: BaseNavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logging)
        if (savedInstanceState == null) {
            val startedFragment =
                baseNavigationProvider.provideStartedLoggingFragment().newInstance()
            navigator.navigateToFragment(
                toFragment = startedFragment,
                baseNavigationProvider.provideStartedLoggingFragmentTag()
            )
        }
    }

    override fun onResume() {
        super.onResume()
        executor.registerActivity(this)
    }

    override fun onPause() {
        super.onPause()
        executor.unregisterActivity()
    }
}