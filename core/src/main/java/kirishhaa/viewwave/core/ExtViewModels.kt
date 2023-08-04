package kirishhaa.viewwave.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Puts on hold mutable flow and on finish change flow's state to completed (error, success, empty)
 */
inline fun <reified T> ViewModel.handleSingleFinishEvent(
    flow: MutableStateFlow<Finish<T>>,
    noinline someFunc: suspend () -> T,
) {
    viewModelScope.launch {
        flow.value = PendingFinish()
        try {
            val returnValue = someFunc()
            if(returnValue is Unit) {
                flow.value = EmptyFinish()
            } else {
                flow.value = SuccessFinish(returnValue)
            }
        } catch (e: Exception) {
            flow.value = ErrorFinish(e)
        }
    }
}