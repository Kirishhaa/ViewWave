package kirishhaa.viewwave.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

interface AsyncWork<T> {

    val result: Flow<Finish<T>>

    fun onSuccess(block: (T) -> Unit): AsyncWork<T>

    fun onError(block: (Throwable) -> Unit): AsyncWork<T>

    fun enqueue(scope: CoroutineScope, block: suspend () -> T): AsyncWork<T>

    fun setUpdatable(updatable: Boolean): AsyncWork<T>

    fun cancel()

}

private class SimpleAsyncWork<T> : AsyncWork<T> {

    private var job: Job? = null

    private var updatable = false

    override val result: MutableStateFlow<Finish<T>> = MutableStateFlow(PendingFinish())

    private var successCallback: ((T) -> Unit)? = null
    private var errorCallback: ((Throwable) -> Unit)? = null

    override fun onSuccess(block:(T) -> Unit): AsyncWork<T> {
        this.successCallback = block
        return this
    }

    override fun onError(block: (Throwable) -> Unit): AsyncWork<T> {
        this.errorCallback = block
        return this
    }

    override fun setUpdatable(updatable: Boolean): AsyncWork<T> {
        this.updatable = updatable
        return this
    }

    override fun cancel() {
        job?.cancel()
        result.value = PendingFinish()
    }

    override fun enqueue(scope: CoroutineScope, block: suspend () -> T): AsyncWork<T> {
            val job = this.job
            if (updatable || job == null) {
                job?.cancel()
                runAsync(scope, block)
            }
            return this
        }

    private fun runAsync(scope: CoroutineScope, block: suspend () -> T) {
        this.result.value = PendingFinish()
        job = scope.launch {
            var asyncResult: Finish<T>
            coroutineScope {
                asyncResult = try {
                    val returnValue = block()
                    SuccessFinish(returnValue)
                } catch (e: Exception) {
                    ErrorFinish(e)
                }
                notifyUpdates(asyncResult)
            }
        }
        job?.invokeOnCompletion { job=null }
    }

    private fun notifyUpdates(asyncResult: Finish<T>)  {
        val successCallback = this.successCallback
        val errorCallback = this.errorCallback

        if (asyncResult is SuccessFinish && successCallback != null) {
            successCallback(asyncResult.data)
        } else if (asyncResult is ErrorFinish && errorCallback != null) {
            errorCallback(asyncResult.error)
        }

        this.result.value = asyncResult

        this.successCallback = null
        this.errorCallback = null
    }
}

class AsyncWorkManager private constructor() {

    companion object {
        private var instance: AsyncWorkManager? = null
        fun getInstance(): AsyncWorkManager {
            synchronized(this) {
                val instance = this.instance
                if (instance == null) {
                    val newInstance = AsyncWorkManager()
                    this.instance = newInstance
                    return newInstance
                } else {
                    return instance
                }
            }
        }
    }

    private val workersPool = HashMap<Any, AsyncWork<*>?>(64)

    fun <T> getWorker(identifier: Any): AsyncWork<T> {
        val asyncWork = workersPool[identifier]
        if (asyncWork == null) {
            val newAsyncWorker = SimpleAsyncWork<T>()
            workersPool[identifier] = newAsyncWorker
            return newAsyncWorker
        } else {
            return asyncWork as AsyncWork<T>
        }
    }

}
