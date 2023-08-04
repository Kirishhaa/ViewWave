package kirishhaa.viewwave.core

import android.util.Log

fun Any.logD(message: String) {
    Log.d(this::class.simpleName, message)
}

fun Any.logE(message: String) {
    Log.e(this::class.simpleName, message)
}