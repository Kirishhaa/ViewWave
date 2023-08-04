package kirishhaa.viewwave.core.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SingleListViewHolder<ITEMTYPE>(view: View): RecyclerView.ViewHolder(view){

    abstract fun bindItem(item: ITEMTYPE)

}