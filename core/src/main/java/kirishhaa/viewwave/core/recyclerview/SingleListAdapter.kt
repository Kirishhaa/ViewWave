package kirishhaa.viewwave.core.recyclerview

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * Single list typed adapter.
 * @property items - list of generics, that can binds by means of TypeViewHolder method 'bindItem'.
 * Works with TypedViewHolder!
 */
abstract class SingleListAdapter<ITEMTYPE, VH: SingleListViewHolder<ITEMTYPE>>: RecyclerView.Adapter<VH>() {

    protected var items = listOf<ITEMTYPE>()

    override fun getItemCount(): Int = items.size

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("SingleListAdapterSetItems")
    abstract fun setItems( items: List<ITEMTYPE>)

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }
}