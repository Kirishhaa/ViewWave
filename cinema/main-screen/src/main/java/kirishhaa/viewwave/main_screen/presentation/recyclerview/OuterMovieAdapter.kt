package kirishhaa.viewwave.main_screen.presentation.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kirishhaa.viewwave.core.recyclerview.BaseDiffUtil
import kirishhaa.viewwave.core.recyclerview.SingleListAdapter
import kirishhaa.viewwave.core.recyclerview.SingleListViewHolder
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.databinding.MovieRecyclerViewBinding

class OuterMovieAdapter(private val listener: OuterMovieAdapterListener) :
    SingleListAdapter<OuterMovieAdapter.Data, OuterMovieAdapter.ViewHolder>() {

    interface OuterMovieAdapterListener : InnerMovieAdapter.InnerAdapterListener {
        fun onMorePressed(genreId: Int)
    }

    inner class ViewHolder(private val listener: OuterMovieAdapterListener, view: View) :
        SingleListViewHolder<Data>(view) {

        private val binding = MovieRecyclerViewBinding.bind(view)

        override fun bindItem(item: Data) {
            binding.movieRecyclerViewRecyclerView.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

            val adapter = InnerMovieAdapter(listener)
            adapter.setItems(item.movieList)

            binding.movieRecyclerViewRecyclerView.adapter = adapter
            binding.movieRecyclerViewTitle.text = item.category
            binding.movieRecyclerViewMoreLayout.setOnClickListener {
                listener.onMorePressed(item.categoryId)
            }
        }

    }

    class Data(
        val categoryId: Int,
        val category: String,
        val movieList: List<MovieListItem>,
    )

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("SingleListAdapterSetItems")
    override fun setItems(items: List<Data>) {
        val outerMovieDiffUtil = OuterMovieDiffUtil(oldList = this.items, newList = items)
        val calculateDiff = DiffUtil.calculateDiff(outerMovieDiffUtil)
        this.items = items
        calculateDiff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_recycler_view, parent, false)
        return ViewHolder(listener, view)
    }

}

private class OuterMovieDiffUtil(
    oldList: List<OuterMovieAdapter.Data>,
    newList: List<OuterMovieAdapter.Data>,
) : BaseDiffUtil<OuterMovieAdapter.Data>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }

}