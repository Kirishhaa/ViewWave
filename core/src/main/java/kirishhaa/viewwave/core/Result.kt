package kirishhaa.viewwave.core

sealed interface Result<T>

class SuccessResult<T>(val data: T): Result<T>

class ErrorResult<T>(val error: Throwable): Result<T>

class PendingResult<T>: Result<T>

class EmptyResult<T>: Result<T>