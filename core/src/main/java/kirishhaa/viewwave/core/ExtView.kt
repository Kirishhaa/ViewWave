package kirishhaa.viewwave.core

import android.view.ViewGroup
import androidx.core.view.children
import androidx.core.view.isVisible

fun ViewGroup.hideAllViews() {
    this.children.forEach {
        it.isVisible = false
    }
}