package kirishhaa.viewwave.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class StateViewModel<STATETYPE> : ViewModel() {

    abstract val state: Flow<STATETYPE>

    fun <T> handleFinishFlow(
        flow: MutableStateFlow<Finish<T>>,
        block: suspend () -> T,
    ): AsyncWork<T> {
        val asyncManager = AsyncWorkManager.getInstance()
        val asyncWorker = asyncManager.getWorker<T>(flow)
            .enqueue(viewModelScope, block)
        viewModelScope.launch {
            asyncWorker.result.collect { result ->
                flow.value = result
            }
        }
        return asyncWorker
    }
}