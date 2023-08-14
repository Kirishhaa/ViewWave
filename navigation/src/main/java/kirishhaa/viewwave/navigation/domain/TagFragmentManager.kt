package kirishhaa.viewwave.navigation.domain

import kirishhaa.viewwave.core.logD

/**
 * Base singleton to handle fragment stack-navigation
 */
internal object TagFragmentManager {

    /**
     *     String -> started fragment tag,
     *     List<String> -> backStack of  fragment's tags on the top of the initial fragment
     *     (with saved sequence)
     */
    private val hashMap = HashMap<String, List<String>>()

    /**
     * puts fragmentTag (valueTag) in parentTag's fragment's call stack (works like hashMap
     * with linked list collision)
     */
    fun putFragmentByTag(parentTag: String, fragmentTag: String) {
        val tagsStack = hashMap[parentTag] ?: emptyList()
        val lastTag = tagsStack.lastOrNull()
        val newStack = if (lastTag != fragmentTag) tagsStack + fragmentTag else tagsStack
        logD("newStack = $newStack")
        hashMap[parentTag] = newStack
    }

    fun getFragmentStack(parentTag: String): List<String> {
        return hashMap[parentTag] ?: emptyList()
    }

    /**
     * return parentTag by fragmentTag (valueTag)
     */
    fun getParentTag(fragmentTag: String?): String? {
        hashMap.forEach { entry ->
            if (entry.value.contains(fragmentTag)) {
                return entry.key
            }
        }
        return null
    }

    /**
     * remove fragment with fragmentTag by parentTag (keyTag)
     */
    fun removeChildTag(fragmentTag: String?, parentTag: String?) {
        if (parentTag == null) return
        if (fragmentTag == null) return
        val mutableList = hashMap[parentTag]?.toMutableList() ?: return
        mutableList.remove(fragmentTag)
        hashMap[parentTag] = mutableList
    }

}