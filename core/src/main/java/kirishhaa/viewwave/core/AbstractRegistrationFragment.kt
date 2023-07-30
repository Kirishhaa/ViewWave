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

    protected open fun observeScreenState(root: ViewGroup, flowScreenState: Flow<Result<Any>>,
    doOnError: (ErrorResult<Any>) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            flowScreenState.collect { screenState ->
                when(screenState) {
                    is ErrorResult -> {
                        enableViews(root, true)
                        doOnError(screenState)
                    }

                    is PendingResult -> enableViews(root, false)

                    else -> enableViews(root, true)
                }
            }
        }
    }

    protected open fun enableViews(root: ViewGroup, isEnable: Boolean) {
        root.forEach {
            if(it is ProgressBar) {
                it.isVisible = !isEnable
            } else {
                it.isEnabled = isEnable
            }
        }
    }

}