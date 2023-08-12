package kirishhaa.viewwave.main_screen.presentation.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import kirishhaa.viewwave.core.recyclerview.SingleListAdapter
import kirishhaa.viewwave.core.recyclerview.SingleListViewHolder
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.databinding.MovieRecycleItemBinding

class AllMovieAdapter(private val listener: Listener) :
    SingleListAdapter<MovieListItem, AllMovieAdapter.ViewHolder>() {

    interface Listener {
        fun onMoviePressed(id: Int)
        fun loadMovies()
    }

    inner class ViewHolder(view: View) : SingleListViewHolder<MovieListItem>(view) {

        override fun bindItem(item: MovieListItem) {
            itemView.setOnClickListener { listener.onMoviePressed(item.id) }

            val binding = MovieRecycleItemBinding.bind(itemView)
            Glide.with(itemView.context).load(item.imagePath).into(binding.movieRecycleItemImage)

            binding.movieRecycleItemTitle.text = item.title
            binding.movieRecycleItemRate.text = item.rate

            if (itemCount - adapterPosition < PAGING_DIFF) {
                listener.loadMovies()
            }

        }
    }

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("SingleListAdapterSetItems")
    override fun setItems(items: List<MovieListItem>) {
        val movieListDiffUtil = MovieListDiffUtil(oldList = this.items, newList = items)
        val calculateDiff = DiffUtil.calculateDiff(movieListDiffUtil)
        this.items = items
        calculateDiff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_recycle_item, parent, false)
        return ViewHolder(view)
    }

    companion object {
        private const val PAGING_DIFF = 5
    }

}