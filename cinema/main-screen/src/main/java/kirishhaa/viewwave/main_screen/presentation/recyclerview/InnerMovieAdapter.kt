package kirishhaa.viewwave.main_screen.presentation.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import kirishhaa.viewwave.core.recyclerview.SingleListAdapter
import kirishhaa.viewwave.core.recyclerview.SingleListViewHolder
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.data.MovieListItem

class InnerMovieAdapter(private val listener: InnerAdapterListener) :
    SingleListAdapter<MovieListItem, InnerMovieAdapter.ViewHolder>() {

    interface InnerAdapterListener {
        fun onMoviePressed(id: Int)
    }

    class ViewHolder(private val listener: InnerAdapterListener, view: View) :
        SingleListViewHolder<MovieListItem>(view) {

        private val itemImage: ImageView = view.findViewById(R.id.movie_recycle_item_image)
        private val itemTitle: TextView = view.findViewById(R.id.movie_recycle_item_title)
        private val itemRate: TextView = view.findViewById(R.id.movie_recycle_item_rate)

        override fun bindItem(item: MovieListItem) {
            Glide.with(itemView.context).load(item.imagePath).into(itemImage)
            itemTitle.text = item.title
            itemRate.text = item.rate

            itemView.setOnClickListener {
                listener.onMoviePressed(item.id)
            }
        }

    }

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("SingleListAdapterSetItems")
    override fun setItems(items: List<MovieListItem>) {
        val diffUtil = MovieListDiffUtil(oldList = this.items, newList = items)
        val calculateDiff = DiffUtil.calculateDiff(diffUtil)
        this.items = items
        calculateDiff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_recycle_item, parent, false)
        return ViewHolder(listener, inflate)
    }

}