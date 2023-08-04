package kirishhaa.viewwave.core

sealed interface Finish<T>

class SuccessFinish<T>(val data: T): Finish<T>

class ErrorFinish<T>(val error: Throwable): Finish<T>

class PendingFinish<T>: Finish<T>

class EmptyFinish<T>: Finish<T>