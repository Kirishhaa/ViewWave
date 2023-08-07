package kirishhaa.viewwave.main_screen.presentation.recyclerview.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.qualifiers.ApplicationContext
import kirishhaa.viewwave.core.recyclerview.SingleListAdapter
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.data.MovieListItem

class MovieAdapter @AssistedInject constructor(
    @ApplicationContext private val appContext: Context,
    @Assisted private val listener: Listener
    ): SingleListAdapter<MovieListItem, MovieViewHolder>() {

    @AssistedFactory
    interface Factory{
        fun create(listener: Listener): MovieAdapter
    }

    interface Listener {
        fun onMovieListItemClicked(item: MovieListItem)
        fun loadMovies()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        if(items.size-position<PAGING_DIFF) listener.loadMovies()
    }

    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("SingleListAdapterSetItems")
    override fun setItems(items: List<MovieListItem>) {
        val diffUtilCallback = MovieDiffUtil(
            oldList = this.items,
            newList = items
        )
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        this.items = items
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_recycle_item, parent, false)
        return MovieViewHolder(appContext, listener, view)
    }

    companion object{
        private const val PAGING_DIFF = 5
    }

}