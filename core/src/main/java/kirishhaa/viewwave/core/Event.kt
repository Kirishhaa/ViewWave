package kirishhaa.viewwave.core

class Event<T>(private val value: T) {

    private var isRequested = false

    fun getValue():T? {
        return if(isRequested){
            null
        } else {
            isRequested = true
            value
        }
    }
}