package kirishhaa.viewwave.core.recyclerview

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtil<ITEMTYPE>(
    protected val oldList: List<ITEMTYPE>,
    protected val newList: List<ITEMTYPE>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

}