package kirishhaa.viewwave.core

import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.LayoutRes
import androidx.core.view.forEach
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class AbstractRegistrationFragment(@LayoutRes layoutRes: Int): Fragment(layoutRes) {

    /**
     * Make result flow state observer, that disabled all views if result is pending and enabled in other case.
     * doOnError is additional logic executes on error result
     */
    protected fun<T> observeScreenState(root: ViewGroup, flowScreenState: Flow<Finish<T>>,
                                     doOnError: (ErrorFinish<T>) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            flowScreenState.collect { screenState ->
                when(screenState) {
                    is ErrorFinish -> {
                        enableViews(root, true)
                        doOnError(screenState)
                    }

                    is PendingFinish -> enableViews(root, false)

                    else -> enableViews(root, true)
                }
            }
        }
    }

    /**
     * Enable or disable all views, except progressBar.
     * (Implied that every registration fragment has also one general progressBar)
     */
    protected fun enableViews(root: ViewGroup, isEnable: Boolean) {
        root.forEach {
            if(it is ProgressBar) {
                it.isVisible = !isEnable
            } else {
                it.isEnabled = isEnable
            }
        }
    }

}