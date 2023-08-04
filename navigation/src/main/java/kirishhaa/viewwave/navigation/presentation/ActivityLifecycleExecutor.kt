package kirishhaa.viewwave.navigation.presentation

import androidx.fragment.app.FragmentActivity

/**
 * Class-observer that can safety invoke navigation functions on the Activity
 */
internal object ActivityLifecycleExecutor {

    private var activity: FragmentActivity? = null

    private val navigationTasks = mutableListOf<(FragmentActivity) -> Unit>()

    fun registerActivity(activity: FragmentActivity) {
        this.activity = activity
        notifyActivity()
    }

    fun unregisterActivity() {
        activity = null
    }

    fun execute(task: (FragmentActivity) -> Unit) {
        val activity = activity
        if(activity==null) {
            navigationTasks.add(task)
        } else {
            task(activity)
        }
    }

    private fun notifyActivity() {
        navigationTasks.forEachIndexed { index, task ->
            val activity = activity
            if(activity==null) {
                clearBeforeIndexTasks(index)
                return
            }
            task(activity)
        }
        navigationTasks.clear()
    }

    private fun clearBeforeIndexTasks(index: Int) = repeat(index) { navigationTasks.removeFirst() }

}