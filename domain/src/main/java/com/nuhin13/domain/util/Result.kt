package com.nuhin13.domain.util

import com.nuhin13.domain.util.Result.Error
import com.nuhin13.domain.util.Result.Success

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val error: Throwable) : Result<T>()
}

inline fun <T, R> Result<T>.getResult(
    success: (Success<T>) -> R,
    error: (Error<T>) -> R
): R = when (this) {
    is Success -> success(this)
    is Error -> error(this)
}

inline fun <T> Result<T>.onSuccess(
    block: (T) -> Unit
): Result<T> = if (this is Success) also { block(data) } else this

inline fun <T> Result<T>.onError(
    block: (Throwable) -> Unit
): Result<T> = if (this is Error) also { block(error) } else this
