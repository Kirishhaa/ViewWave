package kirishhaa.viewwave.core

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch

fun<T> Fragment.observe(flow: Flow<T>, collector: FlowCollector<T> ): Job {
    return lifecycleScope.launch {
        flow.collect(collector)
    }
}