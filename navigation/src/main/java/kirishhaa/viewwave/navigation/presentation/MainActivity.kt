package kirishhaa.viewwave.navigation.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import kirishhaa.viewwave.navigation.domain.NavigationProvider
import kirishhaa.viewwave.navigation.R
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: GlobalNavigator

    @Inject lateinit var navigationProvider: NavigationProvider

    @Inject internal lateinit var executor: ActivityLifecycleExecutor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null) {
            val startedFragment = navigationProvider.provideStartedFragmentClass().newInstance()
            navigator.navigateToFragment(
                toFragment = startedFragment,
                addToBackStack = false
            )
        }
    }

    override fun onStart() {
        super.onStart()
        executor.registerActivity(this)
    }

    override fun onStop() {
        super.onStop()
        executor.unregisterActivity()
    }

}